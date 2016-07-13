package com.atguigu.cateyes.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
public class Video extends CountryMoveBase {
    private ListView lv_video;
    private int[] img;
    private String[] name;

    public Video(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View videoView = View.inflate(context, R.layout.video, null);
        lv_video= (ListView) videoView.findViewById(R.id.lv_video);
        return videoView;
    }

    @Override
    public void initData() {
        super.initData();
        img=new int[]{R.drawable.b01,R.drawable.b02,R.drawable.b03,R.drawable.b04,R.drawable.b05,R.drawable.b06};
         name=new String[]{"预告片1","预告片2","预告片3","预告片4","预告片5","预告片6"};

        lv_video.setAdapter(new myBaseAdapter());
    }

    private class myBaseAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            VideoHolder videoholder;
            if(convertView==null){
                videoholder=new VideoHolder();
                convertView=View.inflate(context,R.layout.ll_video_item,null);
                videoholder.iv_icon_video= (ImageView) convertView.findViewById(R.id.iv_icon_video);
                videoholder.tv_name_video= (TextView) convertView.findViewById(R.id.tv_name_video);
                convertView.setTag(videoholder);
            }else{
                videoholder= (VideoHolder) convertView.getTag();
            }
            videoholder.iv_icon_video.setBackgroundResource(img[position]);
            videoholder.tv_name_video.setText(name[position]);

            return convertView;
        }
    }
    static class VideoHolder{
        ImageView iv_icon_video;
        TextView tv_name_video;
    }
}
