package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.StoryHeadBean;
import com.atguigu.cateyes.popu_window.Popu;
import com.atguigu.cateyes.sore.GoodDeatils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
public class StoreHeadActivity extends Activity implements View.OnClickListener {
    private String url;
    private String name;
    private List<StoryHeadBean.DataBean.ListBean> list;
    private GridView sotre_gv_one;
    private RelativeLayout rl_checkbox;
    private CheckBox cb_sotre_one;
    private Popu popu;
    private CheckBox cb_sotre_two;
    private CheckBox cb_sotre_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_head);
        Intent intent = getIntent();
           /*得到ur地址*/
          url = intent.getStringExtra("url");
          name = intent.getStringExtra("name");
          /*初始化数据*/
           initView();
          /*联网请求数据*/
           getDataFromNet();
           Log.e("hhh",name+"====="+url);


    }

    private void initView() {
         cb_sotre_one= (CheckBox) findViewById(R.id.cb_sotre_one);
         cb_sotre_two= (CheckBox) findViewById(R.id.cb_sotre_two);
         cb_sotre_three= (CheckBox) findViewById(R.id.cb_sotre_three);
        sotre_gv_one= (GridView) findViewById(R.id.sotre_gv_one);
         rl_checkbox= (RelativeLayout) findViewById(R.id.rl_checkbox);
        /*返回监听*/
        ImageView imageview_store_back= (ImageView) findViewById(R.id.imageview_store_back);
        imageview_store_back.setOnClickListener(this);
        /*创建popu对象*/
         popu =new  Popu(StoreHeadActivity.this,rl_checkbox);
        /*checkbox做监听*/
        cb_sotre_one.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        cb_sotre_two.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        cb_sotre_three.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        /*给每一个gridView的item设置监听*/
        sotre_gv_one.setOnItemClickListener(new MyOnItemClickListener());
    }

    private void getDataFromNet() {
        RequestParams params=new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("hhh", name + "请求数据成功=====" + result);
                /*解析数据*/
                progressData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("hhh", name + "请求数据错误=====" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("hhh", name + "请求数据onCancelled=====" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("hhh", name + "onFinished=====");
            }
        });
    }

    private void progressData(String json) {
        StoryHeadBean storyHeadBean = new Gson().fromJson(json, StoryHeadBean.class);
        list = storyHeadBean.getData().getList();
        Log.e("hhh", name + "=====list集合解析成功");
        /*设置设配器*/
        sotre_gv_one.setAdapter(new MyBaseAdapter());
    }

    @Override
    public void onClick(View v) {
        finish();

    }

    private class MyBaseAdapter extends BaseAdapter {
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
            ViewHolder viewholder;
            if(convertView==null){
                 viewholder=new ViewHolder();
                 convertView=View.inflate(StoreHeadActivity.this,R.layout.gv_storehead_item,null);
                 viewholder.iv_storyhead_icon= (ImageView) convertView.findViewById(R.id.iv_storyhead_icon);
                 viewholder.tv_storyhead_describe= (TextView) convertView.findViewById(R.id.tv_storyhead_describe);
                 viewholder.tv_storyhead_price= (TextView) convertView.findViewById(R.id.tv_storyhead_price);
                 viewholder.tv_storyhead_value= (TextView) convertView.findViewById(R.id.tv_storyhead_value);
                 convertView.setTag(viewholder);
            }else{
                viewholder= (ViewHolder) convertView.getTag();
            }
            StoryHeadBean.DataBean.ListBean listBean = list.get(position);
            viewholder.tv_storyhead_describe.setText(listBean.getTitle());
            viewholder.tv_storyhead_price.setText(listBean.getPrice()+"元");
            viewholder.tv_storyhead_value.setText(listBean.getValue()+"元");
            x.image().bind(viewholder.iv_storyhead_icon,listBean.getPic());
            return convertView;
        }
    }
    static class ViewHolder{
        ImageView iv_storyhead_icon;
        TextView tv_storyhead_describe;
        TextView tv_storyhead_price;
        TextView tv_storyhead_value;
    }

     /*checkbox监听*/

    private class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.cb_sotre_one:
                    if(isChecked){
                        cb_sotre_two.setChecked(false);
                        cb_sotre_three.setChecked(false);
                        popu.showPopupWindow();
                    }else{
                        popu.dismiss();
                    }
                    break;
                case R.id.cb_sotre_two:
                    if(isChecked){
                        cb_sotre_one.setChecked(false);
                        cb_sotre_three.setChecked(false);
                        popu.showPopupWindow();
                    }else{
                        popu.dismiss();
                    }

                    break;
                case R.id.cb_sotre_three:
                    if(isChecked){
                        cb_sotre_one.setChecked(false);
                        cb_sotre_two.setChecked(false);
                        popu.showPopupWindow();
                    }else{
                        popu.dismiss();
                    }

                    break;
            }


        }
    }

    private class MyOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            url="http://api.maoyan.com/mallpro/dealDetail.json?dealid=33527771";
            int dealid = list.get(position).getDealid();
            String replaceUrl= url.replace("33527771", dealid + "");
            Intent intent=new Intent(StoreHeadActivity.this, GoodDeatils.class);
            intent.putExtra("url",replaceUrl);
            startActivity(intent);

        }
    }
}
