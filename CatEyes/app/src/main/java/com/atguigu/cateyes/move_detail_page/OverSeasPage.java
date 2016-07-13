package com.atguigu.cateyes.move_detail_page;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyes.Country_movie.AmericanFilm;
import com.atguigu.cateyes.Country_movie.JapanFilm;
import com.atguigu.cateyes.Country_movie.KoreaFilm;
import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.OverSearsCountryBean;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;
import com.atguigu.cateyes.move_detail_base_page.MoveDetailsBase;
import com.atguigu.cateyes.url.Url;
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
public class OverSeasPage extends MoveDetailsBase {
@ViewInject(R.id.tab_layout_overseas)
  private TabLayout tab_layout_overseas;

    @ViewInject(R.id.viewpager_overseas)
    private ViewPager viewpager_overseas;

    private List<CountryMoveBase> countrymovebases;

    private OverSearsCountryBean overSearsCountryBean;

    public OverSeasPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        /*加载布局*/
        View overseasView = View.inflate(context, R.layout.overseas_show_page, null);
        x.view().inject(this, overseasView);

     return overseasView;

    }

    private void getCountryDataFromNet() {
        RequestParams params=new RequestParams(Url.OVERSEAS_COUNTRY);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG","OverSeasPage======"+result);
                /*解析海外国家数据*/
                processOverSearsCountry(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","OverSeasPage======onError()"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","OverSeasPage======onCancelled()"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG","OverSeasPage======onFinished()");
            }
        });
    }
    /*解析海外国家数据*/
    private void processOverSearsCountry(String Json) {
         overSearsCountryBean = new Gson().fromJson(Json, OverSearsCountryBean.class);
          /*viewpage 设置适配器*/
        viewpager_overseas.setAdapter(new MyViewPagerAdapter());

            /*TabLayout 与viewpager 相关联*/
         tab_layout_overseas.setupWithViewPager(viewpager_overseas);
         /*设置TabLayout的选项卡监听：*/
         tab_layout_overseas.setOnTabSelectedListener(new OnTabSelectedListener());
        /*设置TabLayout.TabLayoutOnPageChangeListener,给谁设置呢？当然是ViewPager了*/
//        final TabLayout.TabLayoutOnPageChangeListener listener =
//                new TabLayout.TabLayoutOnPageChangeListener(tab_layout_overseas);
//                 viewpager_overseas.addOnPageChangeListener(listener);
       // viewpager_overseas.addOnPageChangeListener(new MyOnPageChangeListener());


//        countrymovebases.get(0).initData();
    }

//    private void initdata() {
//        countrymovebases=new ArrayList<>();
//        countrymovebases.add(new AmericanFilm(context));
//
//    }


    @Override
    public void initData() {
        super.initData();
         /*加载数据*/
        countrymovebases=new ArrayList<>();
        countrymovebases.add(new AmericanFilm(context));
        countrymovebases.add(new KoreaFilm(context));
        countrymovebases.add(new JapanFilm(context));
        /*请求海外国家数据*/
        getCountryDataFromNet();
    }

    /*设置viewpager的适配器*/
    private class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return overSearsCountryBean.getData().getAreas().get(position).getName();
        }

        @Override
    public Object instantiateItem(ViewGroup container, int position) {
            countrymovebases.get(position).initData();
            View rootView = countrymovebases.get(position).rootView;

//            if (!countrymovebases.get(position).isInitData) {

//            }

            container.addView(rootView);
            return rootView ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
        public int getCount() {
            return countrymovebases.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
/*设置TabLayout的选项卡监听：*/
    private class OnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewpager_overseas.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

//    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
////            if (!flag) {
////                countrymovebases.get(position).initData();
////            }
//            countrymovebases.get(position).initData();
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }
}
