package com.atguigu.cateyes.main_page;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyes.main_base_page.MainBase;
import com.atguigu.cateyes.search.CinemaSearch;
import com.atguigu.cateyes.view.CinemaView;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class CinemaPage extends MainBase {
    private CinemaView cinemaView;

    public CinemaPage(Context context) {
        super(context);
        /*设置titilebar*/
        settingTitleBar();
    }

    private void settingTitleBar() {
        rl_switch_movepage.setVisibility(View.GONE);

        ib_screen_cinema.setVisibility(View.VISIBLE);
        ib_search_cinema.setVisibility(View.VISIBLE);
        tv_cinema_cinema.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {
        super.initData();
         cinemaView = new CinemaView(context);
        viewpager_movepage.setAdapter(new MyViewPager());
        ib_search_cinema.setOnClickListener(new MyOnClickListener());
    }

    private class MyViewPager extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            cinemaView.initData();
            View rootView = cinemaView.rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,CinemaSearch.class);
                  context.startActivity(intent);

        }
    }
}
