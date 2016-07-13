package com.atguigu.cateyes.main_page;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyes.mine.LogIn;
import com.atguigu.cateyes.view.MineView;
import com.atguigu.cateyes.main_base_page.MainBase;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class MinePage extends MainBase {
    public MinePage(Context context) {
        super(context);
        settingTitleBar();
    }

    private void settingTitleBar() {
         /*发现界面隐藏*/
        tv_find_find.setVisibility(View.GONE);
          /*电影页面标题栏隐藏*/
        rl_switch_movepage.setVisibility(View.GONE);
        tv_beijing_movepage.setVisibility(View.GONE);
        iv_beijing_right_movepage.setVisibility(View.GONE);

        rl_login_mine.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {
        super.initData();
       viewpager_movepage.setAdapter(new MyViewPageAdapter());
    }

    private class MyViewPageAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View mineView = new MineView(context).initView();
            container.addView(mineView);
            rl_login_mine.setOnClickListener(new myOnClickListener());
            return mineView;
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

    private class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, LogIn.class);
            context.startActivity(intent);
        }
    }
}
