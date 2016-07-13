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
import com.atguigu.cateyes.bean.AmericanFilmBean;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class AmericanFilm extends CountryMoveBase{
    private ListView list_view_american_film;
    private AmericanFilmBean americanFilmBean;

    public AmericanFilm(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View americanfilm = View.inflate(context, R.layout.americanfilm, null);
         list_view_american_film = (ListView) americanfilm.findViewById(R.id.list_view_american_film);

        Log.e("dujianbo","我被执行");

        return americanfilm;
    }


    @Override
    public void initData() {
        super.initData();
        //请求网络数据
//        isInitData = true;
        Log.e("1111","初始化美国数据");

        getDataFromNet();
    }

    /*请求网络数据*/
    private void getDataFromNet() {
        Log.e("TAG", "44444444444444444444444444444444444");
        RequestParams params=new RequestParams(Url.AMERICAMOVIES);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "AmericanFilm======电影" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished()");
            }
        });
    }
      /*解析数据*/
    private void processData(String json) {
        americanFilmBean = new Gson().fromJson(json, AmericanFilmBean.class);
        Log.e("dujianbo",americanFilmBean.toString());
          /*设置适配器*/
        Log.e("dujianbo",americanFilmBean.toString());
        list_view_american_film.setAdapter(new MyBaseAdapter());

    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {

            return americanFilmBean.getData().getComing().size();
        }

        @Override
        public Object getItem(int position) {
            return americanFilmBean.getData().getComing().get(position) ;
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
                convertView=View.inflate(context,R.layout.americanfilm_item,null);
                viewholder.iv_american_file_icon= (ImageButton) convertView.findViewById(R.id.iv_american_file_icon);
                viewholder.tv_american_file_name= (TextView) convertView.findViewById(R.id.tv_american_file_name);
                viewholder.iv_american_file_style= (ImageView) convertView.findViewById(R.id.iv_american_file_style);
                viewholder.tv_american_file_scm= (TextView) convertView.findViewById(R.id.tv_american_file_scm);
                viewholder.tv_american_file_showInfo= (TextView) convertView.findViewById(R.id.tv_american_file_showInfo);
                viewholder.tv_american_file_scores= (TextView) convertView.findViewById(R.id.tv_american_file_scores);
                viewholder.bt_american_file_buy= (Button) convertView.findViewById(R.id.bt_american_file_buy);
                viewholder.iv_american_file_tag= (ImageView) convertView.findViewById(R.id.iv_american_file_tag);
                convertView.setTag(viewholder);
            }else{
                viewholder= (ViewHolder) convertView.getTag();
                AmericanFilmBean.DataBean.ComingBean comingBean = americanFilmBean.getData().getComing().get(position);
                /*请求图片*/
                String imgUrl = comingBean.getImg();
                String replace = imgUrl.replace("w.h", "168.110");
                x.image().bind(viewholder.iv_american_file_icon,replace);
                    /*设置电影名称*/
                viewholder.tv_american_file_name.setText(comingBean.getNm());
                  /*描述*/
                viewholder.tv_american_file_scm.setText(comingBean.getScm());
                  /*主演*/
                viewholder.tv_american_file_showInfo.setText(comingBean.getDesc());
                viewholder.tv_american_file_scores.setText(comingBean.getWish()+"想看");

            }
            return convertView;
        }
    }
    static class ViewHolder{
      ImageButton iv_american_file_icon;
       TextView tv_american_file_name;
        ImageView iv_american_file_style;
        ImageView iv_american_file_tag;
        TextView tv_american_file_scm;
        TextView tv_american_file_showInfo;
        TextView tv_american_file_scores;
        Button bt_american_file_buy;



    }

}
