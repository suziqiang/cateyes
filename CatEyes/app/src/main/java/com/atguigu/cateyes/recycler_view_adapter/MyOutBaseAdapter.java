package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.FindListViewBean;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class MyOutBaseAdapter extends BaseAdapter{
    /**
     * 能播放视频
     */
    private static final int FOUR =0;

    /**
     * 加载三个一样大的图片
     */
    private static final int TWO =1;

    /**
     * 不能播放视频
     */
    private static final int SEVEN =2;

    /**
     * 加载三个不一样的图片
     */
    private static final int EIGHT =3;

    private Context context;
    private List<FindListViewBean.DataBean.FeedsBean> feeds;
    public MyOutBaseAdapter(Context context, List<FindListViewBean.DataBean.FeedsBean> feeds){
        this.context=context;
        this.feeds=feeds;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }
    /**
     返回item布局的类型
     */
    @Override
    public int getItemViewType(int position) {
        FindListViewBean.DataBean.FeedsBean feedsBean = feeds.get(position);
        int feedType = feedsBean.getFeedType();
        int itemViewType = -1;
        Log.e("a", "type===" + feedType);
        if(4==feedType){
            itemViewType=FOUR;
        }else if(2==feedType){
            itemViewType=TWO;
        }else if(7==feedType){
            itemViewType=SEVEN;
        }else if(8==feedType){
            itemViewType=EIGHT;
        }
        Log.e("a", "我是类型" + itemViewType);
        return itemViewType;
    }

  



    @Override
    public int getCount() {
        return feeds.size();
    }

    @Override
    public Object getItem(int position) {
        return feeds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        int itemViewType = getItemViewType(position);
        if(convertView==null){
            viewholder = new ViewHolder();
            convertView = initView(convertView, viewholder, itemViewType);
            /*实例化公共部分*/
            initViewCommon(convertView, viewholder);
            convertView.setTag(viewholder);

        }else{
            viewholder = (ViewHolder) convertView.getTag();
        }
            bindData(position, viewholder, itemViewType);

        return convertView;
    }
/*绑定数据*/
    private void bindData(int position, ViewHolder viewholder, int itemViewType) {
        FindListViewBean.DataBean.FeedsBean feedsBean = feeds.get(position);


        switch (itemViewType){
            case FOUR:
                 /*绑顶图片*/
                String url = feedsBean.getImages().get(0).getUrl();
                x.image().bind(viewholder.iv_find_video_icon_four, url);
                /*影片标题*/
                viewholder.tv_find_video_describe_four.setText(feedsBean.getTitle());

                /*公共部分绑顶*/
                viewholder.tv_find_public_describe.setText(feedsBean.getUser().getNickName());
                viewholder.tv_find_public_zan.setText(feedsBean.getViewCount() + "");
                viewholder.tv_find_public_pinglun.setText(feedsBean.getCommentCount() + "");
                break;
            case TWO:

                viewholder.tv_find_describe_two.setText(feedsBean.getTitle());
                 /*绑顶图片*/
                List<FindListViewBean.DataBean.FeedsBean.ImagesBean> images = feedsBean.getImages();
                x.image().bind(viewholder.iv_find_one_two,images.get(0).getUrl());
                x.image().bind(viewholder.iv_find_two_two,images.get(1).getUrl());
                x.image().bind(viewholder.iv_find_three_two, images.get(2).getUrl());

                          /*公共部分绑顶*/
                viewholder.tv_find_public_describe.setText(feedsBean.getUser().getNickName());
                viewholder.tv_find_public_zan.setText(feedsBean.getViewCount() + "");
                viewholder.tv_find_public_pinglun.setText(feedsBean.getCommentCount() + "");
                break;
            case SEVEN:
                 /*绑顶图片*/
                      x.image().bind(viewholder.iv_find_icon_seven,feedsBean.getImages().get(0).getUrl());
                     viewholder.tv_find_describe_seven.setText(feedsBean.getTitle());

                /*公共部分绑顶*/
                viewholder.tv_find_public_describe.setText(feedsBean.getUser().getNickName());
                viewholder.tv_find_public_zan.setText(feedsBean.getViewCount() + "");
                viewholder.tv_find_public_pinglun.setText(feedsBean.getCommentCount() + "");
                break;
            case EIGHT:
                viewholder.tv_find_describe_eight.setText(feedsBean.getTitle());
                List<FindListViewBean.DataBean.FeedsBean.ImagesBean> imagesEight= feedsBean.getImages();
                x.image().bind(viewholder.im_find_big_icon_eight, imagesEight.get(0).getUrl());
                x.image().bind(viewholder.im_find_above_icon_eight, imagesEight.get(1).getUrl());
                x.image().bind(viewholder.im_find_down_icon_eight, imagesEight.get(2).getUrl());
                          /*公共部分绑顶*/
                viewholder.tv_find_public_describe.setText(feedsBean.getUser().getNickName());
                viewholder.tv_find_public_zan.setText(feedsBean.getViewCount() + "");
                viewholder.tv_find_public_pinglun.setText(feedsBean.getCommentCount() + "");
                break;



        }


    }

    private void initViewCommon(View convertView, ViewHolder viewholder) {
        /*公共的控件*/
                viewholder.tv_find_public_describe= (TextView) convertView.findViewById(R.id.tv_find_public_describe);
                viewholder.tv_find_public_zan= (TextView) convertView.findViewById(R.id.tv_find_public_zan);
                viewholder.tv_find_public_pinglun= (TextView) convertView.findViewById(R.id.tv_find_public_pinglun);
    }
    /*实例各个布局控件*/
    private View initView(View convertView, ViewHolder viewholder, int itemViewType) {
        switch (itemViewType){
            case FOUR:
                    convertView=View.inflate(context, R.layout.find_listview__four,null);
                viewholder.iv_find_video_icon_four= (ImageView) convertView.findViewById(R.id.iv_find_video_icon_four);
                viewholder.tv_find_video_describe_four= (TextView) convertView.findViewById(R.id.tv_find_video_describe_four);
                break;
            case TWO:
                convertView=View.inflate(context,R.layout.find_listview_two,null);
                viewholder.tv_find_describe_two= (TextView) convertView.findViewById(R.id.tv_find_describe_two);
                viewholder.iv_find_one_two= (ImageView) convertView.findViewById(R.id.iv_find_one_two);
                viewholder.iv_find_two_two= (ImageView) convertView.findViewById(R.id.iv_find_two_two);
                viewholder.iv_find_three_two= (ImageView) convertView.findViewById(R.id.iv_find_three_two);
                break;
            case SEVEN:
                convertView=View.inflate(context,R.layout.find_listview_seven,null);
                viewholder.iv_find_icon_seven= (ImageView) convertView.findViewById(R.id.iv_find_icon_seven);
                viewholder.tv_find_describe_seven= (TextView) convertView.findViewById(R.id.tv_find_describe_seven);

                break;
            case EIGHT:
                convertView=View.inflate(context,R.layout.find_listview_eight,null);
                viewholder.tv_find_describe_eight= (TextView) convertView.findViewById(R.id.tv_find_describe_eight);
                viewholder.im_find_big_icon_eight= (ImageView) convertView.findViewById(R.id.im_find_big_icon_eight);
                viewholder.im_find_above_icon_eight= (ImageView) convertView.findViewById(R.id.im_find_above_icon_eight);
                viewholder.im_find_down_icon_eight= (ImageView) convertView.findViewById(R.id.im_find_down_icon_eight);
                break;
        }

        return convertView;
    }

    static class ViewHolder{
        /*Four布局控件*/
        ImageView iv_find_video_icon_four;
        TextView tv_find_video_describe_four;
        /*two个布局控件*/
        TextView tv_find_describe_two;
        ImageView iv_find_one_two;
        ImageView iv_find_two_two;
        ImageView iv_find_three_two;
        /*seven个布局控件*/
        ImageView iv_find_icon_seven;
        TextView tv_find_describe_seven;
        /*eigth个布局控件*/
        TextView tv_find_describe_eight;
        ImageView im_find_big_icon_eight;
        ImageView im_find_above_icon_eight;
        ImageView im_find_down_icon_eight;


        /*公共部分的控件*/
        TextView tv_find_public_describe;
        TextView tv_find_public_zan;
        TextView tv_find_public_pinglun;
    }
}
