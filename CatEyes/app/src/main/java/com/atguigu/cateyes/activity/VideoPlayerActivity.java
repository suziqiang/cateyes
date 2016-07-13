package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;
import com.atguigu.cateyes.video.Comment;
import com.atguigu.cateyes.video.Video;
import com.atguigu.cateyes.viewpage.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class VideoPlayerActivity extends Activity {
    private ImageView iv_videoview_icon;
    private TextView tv_videoview_name;
    private TextView tv_videoview_detail;
    private TextView tv_videoview_score;
    private Button button_videoview_buy;
    private VideoView videoview_videoplayer_play;
    private ListView listview_videoplayer;
    List<View> date;
    private ArrayList<CountryMoveBase> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);
        initView();
    }

    private void initView() {
        //头布局<include layout="@layout/topview_videoview"/>

        View topview_videoview = View.inflate(this, R.layout.topview_videoview, null);
        videoview_videoplayer_play = (VideoView) findViewById(R.id.videoview_videoplayer_play);
        listview_videoplayer= (ListView) findViewById(R.id.listview_videoplayer);
        listview_videoplayer.addHeaderView(topview_videoview);


        iv_videoview_icon= (ImageView) findViewById(R.id.iv_videoview_icon);
        tv_videoview_name= (TextView) findViewById(R.id.tv_videoview_name);
        tv_videoview_detail= (TextView) findViewById(R.id.tv_videoview_detail);
        tv_videoview_score= (TextView) findViewById(R.id.tv_videoview_score);
        button_videoview_buy= (Button) findViewById(R.id.button_videoview_buy);
        initData();
    }

    private void initData() {
        list=new ArrayList<>();
        list.add(new Video(this));
        list.add(new Comment(this));

        listview_videoplayer.setAdapter(new MyBaseAdapter());
    }


    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
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
                convertView=View.inflate(VideoPlayerActivity.this,R.layout.video_player_items,null);
                viewholder.viewpager_videoview= (MyViewPager) convertView.findViewById(R.id.viewpager_videoview);
                convertView.setTag(viewholder);
            }else{
                viewholder= (ViewHolder) convertView.getTag();
            }
            viewholder.viewpager_videoview.setAdapter(new MyPageAdapter());
            return convertView;
        }
    }



    static class ViewHolder{
        com.atguigu.cateyes.viewpage.MyViewPager viewpager_videoview;
    }

    private class MyPageAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            list.get(position).initData();
            View rootView = list.get(position).rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
