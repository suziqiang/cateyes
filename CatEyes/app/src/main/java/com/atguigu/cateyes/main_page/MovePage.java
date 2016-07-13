package com.atguigu.cateyes.main_page;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.main_base_page.MainBase;
import com.atguigu.cateyes.move_detail_base_page.MoveDetailsBase;
import com.atguigu.cateyes.move_detail_page.HotShowsPage;
import com.atguigu.cateyes.move_detail_page.OverSeasPage;
import com.atguigu.cateyes.move_detail_page.StayShowPage;

import org.xutils.common.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class MovePage extends MainBase{

    private boolean colorwhit;
    private List<MoveDetailsBase> moveDetailsBases;


    public MovePage(Context context) {
        super(context);
    }
//public ImageView iv_move_whiteblock_movepage;移动的白块
private int marginLeft;
    @Override
    public void initData() {
        super.initData();
        moveDetailsBases=new ArrayList<>();
        moveDetailsBases.add(new HotShowsPage(context));
        moveDetailsBases.add(new StayShowPage(context));
        moveDetailsBases.add(new OverSeasPage(context));
        viewpager_movepage.setAdapter(new MyPagerAdpter());
        //setRadioButton();
        // 红点移动的距离 ：间距=手指滑动的距离 ：屏幕宽度
         /*红点移动的距离=页面移动的百分比*总间距
        * 真正在屏幕上移动的距离=起始坐标+红点移动举距离*/
        iv_move_whiteblock_movepage.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

       /*给radiobutton设置监听*/
        rg_switch_movepage.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        /*给viewPager设置监听*/
        viewpager_movepage.addOnPageChangeListener(new MyOnPageChangeListener());
     }

    private class MyPagerAdpter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            moveDetailsBases.get(position).initData();
            View rootView = moveDetailsBases.get(position).rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return moveDetailsBases.size() ;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        /*position */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //红点移动的距离=页面移动的百分比*总间距
            //int slideleft= (int) (positionOffset*marginLeft);
            //真正在屏幕上移动的距离=起始坐标+红点移动举距离
            Log.e("TAG", " onPageScrolled()");
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(DensityUtil.dip2px(50),DensityUtil.dip2px(30));
            int slideleft = position * marginLeft + (int) (positionOffset * marginLeft);
            params.leftMargin = slideleft;
            iv_move_whiteblock_movepage.setLayoutParams(params);


        }

        @Override
        public void onPageSelected(int position) {
             /*得到文字button上的文字*/
            final Button  childAt = (Button) rg_switch_movepage.getChildAt(position);
            iv_move_whiteblock_movepage.setText(childAt.getText());
            childAt.setTextColor(Color.TRANSPARENT);
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    childAt.setTextColor(Color.WHITE);
                }
            },500);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override
        public void onGlobalLayout() {
                 /*总间距*/
                marginLeft =rg_switch_movepage.getChildAt(1).getLeft() - rg_switch_movepage.getChildAt(0).getLeft()+DensityUtil.dip2px(20);
        }
    }
    /*给radiobutton设置监听 点击切换viewpager页面*/
    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case  R.id.rb_hotshows_movepage:

                    viewpager_movepage.setCurrentItem(0);

                    break;
                case  R.id.rb_stayshows_movepage:
                    viewpager_movepage.setCurrentItem(1);
                    break;
                case  R.id.rb_overseas_movepage:
                    viewpager_movepage.setCurrentItem(2);
                    break;
            }

        }
    }



}
