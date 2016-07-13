package com.atguigu.cateyes.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.DensityUtil;
import com.atguigu.cateyes.activity.FindWeb;
import com.atguigu.cateyes.bean.FindListViewBean;
import com.atguigu.cateyes.bean.FindViewPageBean;
import com.atguigu.cateyes.recycler_view_adapter.MyOutBaseAdapter;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class FindView {
    private Context context;
    public  View rootView;
    private ListView lv_find;
    private ViewPager viewpager_find;
    private RadioButton rb_find_topic;

    private List<FindListViewBean.DataBean.FeedsBean> feeds;
    private List<FindViewPageBean.DataBean> data;
    /**
     * 上一次被高亮显示的位置
     */
    private int prePosition = 0;
    private LinearLayout ll_add_point;
    private RadioButton rb_find_zixun;
    private RadioButton rb_find_yugao;
    private RadioButton rb_find_piaofang;

    public FindView(Context context){
        this.context=context;
       rootView=initView();

    }

    public View initView() {
        /*加载头及相关组件*/
        View topView= View.inflate(context,R.layout.topview_find,null);
        viewpager_find= (ViewPager) topView.findViewById(R.id.viewpager_find);
        rb_find_topic= (RadioButton) topView.findViewById(R.id.rb_find_topic);
        rb_find_zixun= (RadioButton) topView.findViewById(R.id.rb_find_zixun);
        rb_find_yugao= (RadioButton) topView.findViewById(R.id.rb_find_yugao);
        rb_find_piaofang= (RadioButton) topView.findViewById(R.id.rb_find_piaofang);
         ll_add_point= (LinearLayout) topView.findViewById(R.id.ll_add_point);
       /*加载listview*/
        View findView = View.inflate(context, R.layout.page_view_find, null);
         lv_find = (ListView) findView.findViewById(R.id.lv_find);
        lv_find.addHeaderView(topView);
        /*给button设置点击事件*/
        rb_find_topic.setOnClickListener(new MyOnClickListener());
        rb_find_zixun.setOnClickListener(new MyOnClickListener());
        rb_find_yugao.setOnClickListener(new MyOnClickListener());
        rb_find_piaofang.setOnClickListener(new MyOnClickListener());
        return findView;
    }
    public void initData(){
        /*获取listView 的数据*/
        getDataOfListFromNet();
        /*获取ViewPager的数据*/
        getDataOfViewPageFromNet();
    }

    /*获取ViewPager的数据*/
    private void getDataOfViewPageFromNet() {
        RequestParams params= new RequestParams(Url.FIND_ViewPager);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("findview", "findview获取数据成功=============" + result);
                /*解析listView 的数据*/
                processDataOfviewPager(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("findview", "findview获取数据错误=============" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("findview", "findview获取onCancelled=============" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("findview", "findview获取数据成功=============+onFinished");
            }
        });



    }

    private void processDataOfviewPager(String result) {
        FindViewPageBean findViewPageBean = new Gson().fromJson(result, FindViewPageBean.class);
         data = findViewPageBean.getData();
        /*设置ViewPage的Adapter*/
          /*添加红点*/
        addPoint();
        viewpager_find.setAdapter(new MyViewPageAdapter());



    }


    /*获取listView 的数据*/
    private void getDataOfListFromNet() {
        RequestParams params= new RequestParams(Url.FIND_LISTVIEW);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("findList", "findlist获取数据成功=============" + result);
                /*解析listView 的数据*/
                processDataOfListView(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("findList", "findlist获取数据错误=============" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("findList", "findlist获取onCancelled=============" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("findList", "findlist获取数据成功=============+onFinished");
            }
        });
    }

    private void processDataOfListView(String json) {
        FindListViewBean findListViewBean = new Gson().fromJson(json, FindListViewBean.class);
         feeds = findListViewBean.getData().getFeeds();
        Log.e("findList", "findlist解析陈宫=============feeds" + feeds.get(0).getTitle());
         lv_find.setAdapter(new MyOutBaseAdapter(context,feeds));

    }

    private class MyViewPageAdapter extends PagerAdapter {


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View pointView = View.inflate(context, R.layout.fin_viewpager_item, null);
            ImageView iv_viewpager_find = (ImageView) pointView.findViewById(R.id.iv_viewpager_find);
            /*解析图片数据并绑定*/
            if(data!=null){
                x.image().bind(iv_viewpager_find, data.get(position).getImgUrl());
            }else{
                iv_viewpager_find.setBackgroundResource(R.drawable.a5c);
            }
           viewpager_find.addOnPageChangeListener(new MyOnPageChangeListener());
            container.addView(pointView);
            return pointView;

        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            if(data.size()>0){
                return data.size();
            }else{
                return 1;
            }

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    private void addPoint() {
        //把所有的点先移除
        ll_add_point.removeAllViews();
        //设置红点和文本
        for(int i=0;i<data.size();i++){

            ImageView point = new ImageView(context);
            point.setBackgroundResource(R.drawable.point_bg_selector);
            if(i==0){
                point.setEnabled(true);
            }else{
                point.setEnabled(false);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(context,5),DensityUtil.dip2px(context,5));
            if(i != 0){
                params.leftMargin = DensityUtil.dip2px(context, 5);
            }
            point.setLayoutParams(params);

            //添加到显示布局里面
            ll_add_point.addView(point);

        }

    }
    /*viewpager设置监听页面改变 */
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            //1.把上一次的设置默认
            ll_add_point.getChildAt(prePosition).setEnabled(false);
            //2.把当前页面对应的点设置高亮
            ll_add_point.getChildAt(position).setEnabled(true);

            prePosition = position;
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intetnt=new Intent(context,FindWeb.class);
            switch (v.getId()){
                case R.id.rb_find_topic:
                    /*话题*/
                    intetnt.putExtra("biaoti",rb_find_topic.getText());
                    intetnt.putExtra("url", "http://m.maoyan.com/groups?_v_=yes&f=android&userid=-1&pushToken=7e6bd5fe73912116ed3ca24d473265cc37ad738879f590efaf0a436f905b945b103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1");
                    context.startActivity(intetnt);
                break;
                case R.id.rb_find_zixun:
                     /*资讯*/
                    intetnt.putExtra("biaoti",rb_find_zixun.getText());
                    intetnt.putExtra("url","http://m.maoyan.com/groups?_v_=yes&f=android&userid=-1&pushToken=7e6bd5fe73912116ed3ca24d473265cc37ad738879f590efaf0a436f905b945b103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1");
                    context.startActivity(intetnt);

                break;
                case R.id.rb_find_yugao:
                     /*预告片*/
                    intetnt.putExtra("biaoti",rb_find_yugao.getText());
                    intetnt.putExtra("url","http://m.maoyan.com/recommended/videos?_v_=yes&f=android&userid=-1&pushToken=3074f04c84e26a4e7c91f738d9c6bc32951a70fa77b550175da73b29c61ffe5e103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1\\n\"");
                    context.startActivity(intetnt);

                break;
                case R.id.rb_find_piaofang:
                     /*票房*/
                    intetnt.putExtra("biaoti",rb_find_piaofang.getText());
                    intetnt.putExtra("url","http://m.maoyan.com/newGuide/maoyanpiaofang?f=nohdft");
                    context.startActivity(intetnt);
                break;
            }

        }
    }
}
