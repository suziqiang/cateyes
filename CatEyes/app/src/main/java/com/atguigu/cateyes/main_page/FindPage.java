package com.atguigu.cateyes.main_page;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyes.view.FindView;
import com.atguigu.cateyes.main_base_page.MainBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class FindPage extends MainBase {
    private List<FindView> data;
    private View FindView;

    public FindPage(Context context) {
        super(context);
        settingTitleBar();
    }
    private void settingTitleBar() {
        /*电影页面标题栏隐藏*/
        rl_switch_movepage.setVisibility(View.GONE);
        tv_beijing_movepage.setVisibility(View.GONE);
        iv_beijing_right_movepage.setVisibility(View.GONE);
        /*影院页面标题栏隐藏*/
        ib_screen_cinema.setVisibility(View.GONE);
        ib_search_cinema.setVisibility(View.GONE);
        tv_cinema_cinema.setVisibility(View.GONE);
        /*发现界面显示*/
        tv_find_find.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {
        super.initData();
        FindView findView = new FindView(context);
          data = new ArrayList<>();
          data.add(findView);
        viewpager_movepage.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            data.get(position).initData();
            View rootView = data.get(position).rootView;
          /*  View rootView = data.get(position).rootView;*/
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

}
