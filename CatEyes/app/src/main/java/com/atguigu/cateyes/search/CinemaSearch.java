package com.atguigu.cateyes.search;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.PinYinUtils;
import com.atguigu.cateyes.bean.CinemaSearchBean;
import com.atguigu.cateyes.recycler_view_adapter.MyCineamSearchAdapter;
import com.atguigu.cateyes.sql.DBhelper;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class CinemaSearch extends Activity {
    private String replaceUrl;
    private EditText et_soso;
    private List<CinemaSearchBean.DataBean> data;
    private RecyclerView rv_search;
    private MyCineamSearchAdapter myCineamSearchAdapter;
    private LinearLayout ll_search;
    private PopupWindow popupwindow;
    private ListView lv_search;
    private DBhelper dBhelper;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_cinema);
        initView();
         dBhelper = new DBhelper(this, 1);
    }

    private void initView() {
        et_soso = (EditText) findViewById(R.id.et_soso);
        TextView tv_quxiao = (TextView) findViewById(R.id.tv_quxiao);
        rv_search = (RecyclerView) findViewById(R.id.rv_search);
        ll_search= (LinearLayout) findViewById(R.id.ll_search);
         list=new ArrayList<>();
        /*监听文字改变*/
        et_soso.addTextChangedListener(textWatcher);

    }

    private void popuwindow() {
      /*  */
        View historyView = View.inflate(this,R.layout.listview_search, null);
         lv_search= (ListView) historyView.findViewById(R.id.lv_search);
        popupwindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupwindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupwindow.showAsDropDown(et_soso);
            querySQL();
        lv_search.setAdapter(new MyListViewAdapter());
    }

    private void querySQL() {
        SQLiteDatabase readableDatabase = dBhelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query("history", null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String history = cursor.getString(cursor.getColumnIndex("history"));
            list.add(history);
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        /*keyword=c*/
                 /*得到框中的汉字*/
            String text = et_soso.getText().toString();
                /*把汉字存入数据库*/
            insertSQL();
                  /*把汉字变成拼音*/
            String pinYin = PinYinUtils.getPinYin(text);

         /*   Log.e("sssssssss", "更换后的地址======================" + pinYin);
                *//*char a = pinYin.charAt(0);*/


            String url = Url.CINEMA_SEARCH;
            replaceUrl = url.replace("keyword=c", "keyword=" + pinYin);
            Log.e("sssssssss", "更换后的地址======================" + replaceUrl);
            getDataFromNet(replaceUrl);

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.e("bbbbbbbb",s.toString());
            String s1 = s.toString();

            if("".equals(s1)) {
                data.clear();
             /*   myCineamSearchAdapter.notifyDataSetChanged();*/
                list.clear();
                popupwindow.dismiss();
            }

        }
    };

    private void insertSQL() {
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        ContentValues value=new ContentValues();
        value.put("history",et_soso.getText().toString());
        database.insert("history", null, value);
        database.close();


    }

    private void getDataFromNet(String url) {
            RequestParams params = new RequestParams(url);
            x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    progressData(result);
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });
        }

        private void progressData(String Json) {
            CinemaSearchBean cinemaSearchBean = new Gson().fromJson(Json, CinemaSearchBean.class);
            data = cinemaSearchBean.getData();
            Log.e("sssssssss", data.get(0).getAddr());
             myCineamSearchAdapter = new MyCineamSearchAdapter(this, data);
            rv_search.setAdapter(myCineamSearchAdapter);
            myCineamSearchAdapter.notifyDataSetChanged();

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rv_search.setLayoutManager(linearLayoutManager);
            popuwindow();
        }

    private class MyListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                viewHolder=new ViewHolder();
                convertView= View.inflate(CinemaSearch.this, R.layout.popu_window_search_item, null);
                viewHolder.history_tv= (TextView) convertView.findViewById(R.id.history_tv);
                viewHolder.history_delet= (ImageView) convertView.findViewById(R.id.history_delet);
                convertView.setTag(viewHolder);
            }else{
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.history_tv.setText(list.get(position));
            return convertView;
        }
    }
    static class ViewHolder{
        TextView history_tv;
        ImageView history_delet;

    }
}

