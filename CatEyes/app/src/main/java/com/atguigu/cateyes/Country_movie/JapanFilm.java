package com.atguigu.cateyes.Country_movie;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.JapanFilmBean;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class JapanFilm extends CountryMoveBase{
    private ListView list_view_japan_film;
    private List<JapanFilmBean.DataBean.HotBean> hot;

    public JapanFilm(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View japanfilmView = View.inflate(context, R.layout.japanfilm, null);
        list_view_japan_film = (ListView) japanfilmView.findViewById(R.id.list_view_japan_film);
        return japanfilmView;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestParams params= new RequestParams(Url.JAPAN_MOVIES);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "JapanFilm======电影" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "JapanFilm====" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "JapanFilm====onFinished()");
            }
        });
    }

    private void processData(String json) {
        JapanFilmBean japanFilmBean = new Gson().fromJson(json, JapanFilmBean.class);
        hot = japanFilmBean.getData().getHot();
        list_view_japan_film.setAdapter(new MyBaseAdapter());
    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return hot.size();
        }

        @Override
        public Object getItem(int position) {
            return hot.get(position);
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
                convertView=View.inflate(context,R.layout.japanfilm_item,null);
                viewHolder.iv_japan_film_icon= (ImageButton) convertView.findViewById(R.id.iv_japan_film_icon);
                viewHolder.tv_japan_film_name= (TextView) convertView.findViewById(R.id.tv_japan_film_name);
                viewHolder.iv_japan_film_style= (ImageView) convertView.findViewById(R.id.iv_japana_film_style);
                viewHolder.iv_japan_film_tag= (ImageView) convertView.findViewById(R.id.iv_japan_film_tag);
                viewHolder.tv_japan_film_scm= (TextView) convertView.findViewById(R.id.tv_japan_film_scm);
                viewHolder.tv_japan_film_showInfo= (TextView) convertView.findViewById(R.id.tv_japan_film_showInfo);
                viewHolder.tv_japan_film_scores= (TextView) convertView.findViewById(R.id.tv_japan_film_scores);
                convertView.setTag(viewHolder);
            }else{
                viewHolder= (ViewHolder) convertView.getTag();
                JapanFilmBean.DataBean.HotBean hotBean = hot.get(position);
                /*请求图片*/
                String imgUrl = hotBean.getImg();
                String replace = imgUrl.replace("w.h", "168.110");
                x.image().bind(viewHolder.iv_japan_film_icon,replace);
                /*请求电影名*/
                viewHolder.tv_japan_film_name.setText(hotBean.getNm());
                /*请求电影名描述*/
                viewHolder.tv_japan_film_scm.setText(hotBean.getScm());
                /*请求电影主演*/
                viewHolder.tv_japan_film_showInfo.setText(hotBean.getDesc());
                   /*请求多少人想看*/
                viewHolder.tv_japan_film_scores.setText(hotBean.getWish()+"人想看");

            }
            return convertView;
        }
    }
    static class ViewHolder{
        ImageButton iv_japan_film_icon;
        TextView tv_japan_film_name;
        ImageView iv_japan_film_style;
        ImageView iv_japan_film_tag;
        TextView tv_japan_film_scm;
        TextView tv_japan_film_showInfo;
        TextView tv_japan_film_scores;

    }
}
