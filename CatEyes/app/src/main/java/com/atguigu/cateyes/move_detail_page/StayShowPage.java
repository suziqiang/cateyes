package com.atguigu.cateyes.move_detail_page;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.StayShowListViewBean;
import com.atguigu.cateyes.move_detail_base_page.MoveDetailsBase;
import com.atguigu.cateyes.recycler_view_adapter.RecyclerViewAdapterHope;
import com.atguigu.cateyes.recycler_view_adapter.RecyclerViewAdapterPrevue;
import com.atguigu.cateyes.url.Url;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class StayShowPage extends MoveDetailsBase {
    /*头View实例化控件*/
    @ViewInject(R.id.ib_stayshowpage_search)
    private ImageButton ib_stayshowpage_search;

    @ViewInject(R.id.recyclerview_prevue)
    private RecyclerView recyclerview_prevue;

    @ViewInject(R.id.recyclerview_hope)
    private RecyclerView recyclerview_hope;
    /*listview 实例化*/
    @ViewInject(R.id.listview_stayshowpage)
    private ListView listview_stayshowpage;
    /*MaterialRefreshLayout实例化*/
    @ViewInject(R.id.refresh)
    private MaterialRefreshLayout materialRefreshLayout;

    private List<String> datas;
    private StayShowListViewBean stayShowListViewBean;

    public StayShowPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        /*加载头布局*/
        View topView = View.inflate(context, R.layout.stayshows_topview, null);
        x.view().inject(this, topView);
        /*加载listView布局*/
        View listveiw = View.inflate(context, R.layout.listview_stayshowpage, null);
        x.view().inject(this, listveiw);
        /*设置模拟数据*/
        initdata();
        /*联网请求listview的数据*/
        getDataFromNetForListView();
        /*设置第一个recyclerview_prevue*/
        recyclerview_prevue.setAdapter(new RecyclerViewAdapterPrevue(context, datas));
        recyclerview_prevue.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
          /*设置第二个recyclerview_hope*/
        recyclerview_hope.setAdapter(new RecyclerViewAdapterHope(context, datas));
        recyclerview_hope.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        listview_stayshowpage.addHeaderView(topView);
        setRefresh();
        return listveiw;
    }


    private void getDataFromNetForListView() {
        RequestParams param=new RequestParams(Url.STAYSHOWS_LISTVIEW);
        x.http().get(param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG","我是stayshowpage为listView请求的数据,成功"+result);
                progressForlistView(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","我是stayshowpage为listView请求的数据，失败"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","我是stayshowpage为listView请求的数据"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG","我是stayshowpage为listView请求的数据,onFinished()");
            }
        });

    }

    private void progressForlistView(String json) {
         stayShowListViewBean = new Gson().fromJson(json, StayShowListViewBean.class);
         /*设置listView*/
         listview_stayshowpage.setAdapter(new MybaseAdapter());

    }

    private void initdata() {
         datas=new ArrayList<>();
         for(int x=0;x<20;x++){
             String text="黄飞鸿第"+x;
             datas.add(text);
         }
    }

    private class MybaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return stayShowListViewBean.getData().getComing().size();
        }

        @Override
        public Object getItem(int position) {
            return stayShowListViewBean.getData().getComing().get(position);
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
                convertView = View.inflate(context, R.layout.stayshows_listview_item, null);
                viewholder.iv_stayshowspage_listview_item_icon= (ImageButton) convertView.findViewById(R.id.iv_stayshowspage_listview_item_icon);
                viewholder.tv_stayshowspage_listview_item_name= (TextView) convertView.findViewById(R.id.tv_stayshowspage_listview_item_name);
                viewholder.iv_stayshowspage_listview_item_style= (ImageView) convertView.findViewById(R.id.iv_stayshowspage_listview_item_style);
                viewholder.tv_stayshowspage_listview_item_scm= (TextView) convertView.findViewById(R.id.tv_stayshowspage_listview_item_scm);
                viewholder.tv_stayshowspage_listview_item_showInfo= (TextView) convertView.findViewById(R.id.tv_stayshowspage_listview_item_showInfo);
                viewholder.tv_stayshowspage_listview_item_scores= (TextView) convertView.findViewById(R.id.tv_stayshowspage_listview_item_scores);
                viewholder.bt_stayshowspage_listview_item_buy= (Button) convertView.findViewById(R.id.bt_stayshowspage_listview_item_buy);
                viewholder.stayshowspage_listview_item_time= (TextView) convertView.findViewById(R.id.tv_stayshowspage_listview_item_time);
                convertView.setTag(viewholder);

            }else{
                viewholder= (ViewHolder) convertView.getTag();
                /*获取图片*/
                StayShowListViewBean.DataBean.ComingBean comingBean = stayShowListViewBean.getData().getComing().get(position);
                String imgUrl = comingBean.getImg();
                x.image().bind(viewholder.iv_stayshowspage_listview_item_icon, imgUrl);
                /*获取电影名称*/
                viewholder.tv_stayshowspage_listview_item_name.setText(comingBean.getNm());
                /*获取电影描述*/
                viewholder.tv_stayshowspage_listview_item_scm.setText(comingBean.getScm());
                /*获取主演*/
                viewholder.tv_stayshowspage_listview_item_showInfo.setText(comingBean.getDesc());
                viewholder.tv_stayshowspage_listview_item_scores.setText(""+comingBean.getWish());
                /*预售还是想看*/
                if(comingBean.getShowst()==4){
                    viewholder.bt_stayshowspage_listview_item_buy.setBackgroundResource(R.drawable.button_background_seclet1);
                }else{
                    viewholder.bt_stayshowspage_listview_item_buy.setBackgroundResource(R.drawable.button_background_seclet);
                    viewholder.bt_stayshowspage_listview_item_buy.setText("想看");
                }
                /*设置时间*/
                viewholder.stayshowspage_listview_item_time.setText(comingBean.getRt()+"");
            }

            return convertView;
        }
    }
    static class ViewHolder{
        TextView stayshowspage_listview_item_time;
        ImageButton iv_stayshowspage_listview_item_icon;
        TextView tv_stayshowspage_listview_item_name;
        ImageView iv_stayshowspage_listview_item_style;
        TextView tv_stayshowspage_listview_item_scm;
        TextView tv_stayshowspage_listview_item_showInfo;
        TextView tv_stayshowspage_listview_item_scores;
        Button bt_stayshowspage_listview_item_buy;

    }

    /*设置上拉下拉刷新*/
    private void setRefresh() {
        materialRefreshLayout.setLoadMore(true);
       materialRefreshLayout.finishRefreshLoadMore();
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {

                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getDataFromNetForListView();
                        materialRefreshLayout.finishRefresh();


                    }
                }, 3000);

            }

            @Override
            public void onfinish() {
                Toast.makeText(context, "onfinish() 第二页", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {

                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefreshLoadMore();
                        Toast.makeText(context, "没有更多数据 加载更多完成", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);



            }
        });
        materialRefreshLayout.autoRefresh();

    }
}
