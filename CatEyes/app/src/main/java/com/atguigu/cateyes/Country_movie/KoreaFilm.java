package com.atguigu.cateyes.Country_movie;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.KoreaFilmBean;
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
public class KoreaFilm extends CountryMoveBase{
    private ListView list_view_korea_film;
    private List<KoreaFilmBean.DataBean.HotBean> hot;

    public KoreaFilm(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View koreafilmView = View.inflate(context, R.layout.koreafilm, null);
        list_view_korea_film = (ListView) koreafilmView.findViewById(R.id.list_view_korea_film);
        return koreafilmView;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();

    }

    private void getDataFromNet() {
        RequestParams params=new RequestParams(Url.KOREA_MOVIES);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
             Log.e("TAG", "KoreaFilm======电影" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "KoreaFilm====" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", cex.getMessage());
            }

            @Override
            public void onFinished() {
               Log.e("TAG", "KoreaFilm====onFinished()");
            }
        });
    }

    private void processData(String json) {

        Gson gson = new Gson();
        koreaFilmBean = gson.fromJson(json, KoreaFilmBean.class);
        KoreaFilmBean.DataBean data = koreaFilmBean.getData();
        hot = data.getHot();
        list_view_korea_film.setAdapter(new MyBaseAdapter());
    }
    KoreaFilmBean koreaFilmBean;
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
            ViewHolder viewholder;
            if(convertView==null){
                viewholder=new ViewHolder();
                convertView = View.inflate(context, R.layout.koreafilm_item, null);
               viewholder.iv_korea_film_icon= (ImageButton) convertView.findViewById(R.id.iv_korea_film_icon);
               viewholder.tv_korea_film_name= (TextView) convertView.findViewById(R.id.tv_korea_film_name);
               viewholder.iv_korea_film_style= (ImageView) convertView.findViewById(R.id.iv_korea_film_style);
               viewholder.iv_korea_film_tag= (ImageView) convertView.findViewById(R.id.iv_korea_film_tag);
               viewholder.tv_korea_film_scm= (TextView) convertView.findViewById(R.id.tv_korea_film_scm);
               viewholder.tv_korea_film_showInfo= (TextView) convertView.findViewById(R.id.tv_korea_film_showInfo);
               viewholder.tv_korea_film_scores= (TextView) convertView.findViewById(R.id.tv_korea_film_scores);
               viewholder.bt_korea_film_buy= (Button) convertView.findViewById(R.id.bt_korea_film_buy);
                convertView.setTag(viewholder);
            }else{
                viewholder= (ViewHolder) convertView.getTag();
                /*请求图片*/
                KoreaFilmBean.DataBean.HotBean hotBean = hot.get(position);
                String imgUrl = hotBean.getImg();
                String replace = imgUrl.replace("w.h", "168.110");
                x.image().bind(viewholder.iv_korea_film_icon,replace);
                /*请求电影名*/
                viewholder.tv_korea_film_name.setText(hotBean.getNm());
                /*请求电影名描述*/
                viewholder.tv_korea_film_scm.setText(hotBean.getScm());
                /*请求电影主演*/
                viewholder.tv_korea_film_showInfo.setText(hotBean.getDesc());
                   /*请求多少人想看*/
                viewholder.tv_korea_film_scores.setText(hotBean.getWish()+"人想看");
            }
            return convertView;
        }


    }
    static class ViewHolder{
        ImageButton iv_korea_film_icon;
        TextView tv_korea_film_name;
        ImageView iv_korea_film_style;
        ImageView iv_korea_film_tag;
        TextView tv_korea_film_scm;
        TextView tv_korea_film_showInfo;
        TextView tv_korea_film_scores;
        Button bt_korea_film_buy;

    }
}
