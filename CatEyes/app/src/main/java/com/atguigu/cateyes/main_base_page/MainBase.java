package com.atguigu.cateyes.main_base_page;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyes.R;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public  class MainBase {
    public  View rootview;
    public Context context;
    public LinearLayout linearlayout_movepage;

    public TextView tv_beijing_movepage;
    public ImageView iv_beijing_right_movepage;
    public TextView tv_cinema_movepage;
    public RelativeLayout rl_switch_movepage;
    public RadioButton rb_hotshows_movepage;
    public RadioButton rb_stayshows_movepage;
    public RadioButton rb_overseas_movepage;
    public RadioGroup rg_switch_movepage;
    public TextView iv_move_whiteblock_movepage;
    /*cinema页面*/
    public ImageButton ib_screen_cinema;
    public ImageButton ib_search_cinema;
    public TextView tv_cinema_cinema;
    /*find页面*/
    public TextView tv_find_find;
    /*mine 页面*/
    public RelativeLayout rl_login_mine;
    public RadioButton rb_Login_avatar_mine;
    public TextView tv_login_mine;
    public ImageButton ib_others_mine;
    public ViewPager viewpager_movepage;


    public MainBase(Context context) {
        this.context = context;
            rootview=initView();
    }

    public  View initView(){
        View titlebarView = View.inflate(context, R.layout.title_bar, null);
        /*初始化 move页面*/
        linearlayout_movepage= (LinearLayout) titlebarView.findViewById(R.id.linearlayout_movepage);
        tv_beijing_movepage= (TextView) titlebarView.findViewById(R.id.tv_beijing_movepage);
        iv_beijing_right_movepage= (ImageView) titlebarView.findViewById(R.id.iv_beijing_right_movepage);
        tv_cinema_movepage= (TextView) titlebarView.findViewById(R.id.tv_cinema_movepage);
        rl_switch_movepage= (RelativeLayout) titlebarView.findViewById(R.id.rl_switch_movepage);
        rb_hotshows_movepage= (RadioButton) titlebarView.findViewById(R.id.rb_hotshows_movepage);
        rb_stayshows_movepage= (RadioButton) titlebarView.findViewById(R.id.rb_stayshows_movepage);
        rb_overseas_movepage= (RadioButton) titlebarView.findViewById(R.id.rb_overseas_movepage);
        rg_switch_movepage= (RadioGroup) titlebarView.findViewById(R.id.rg_switch_movepage);
        iv_move_whiteblock_movepage= (TextView) titlebarView.findViewById(R.id.iv_move_whiteblock_movepage);
        viewpager_movepage= (ViewPager) titlebarView.findViewById(R.id.viewpager_movepage);

      /*cinema页面*/
        ib_screen_cinema= (ImageButton) titlebarView.findViewById(R.id.ib_screen_cinema);
        ib_search_cinema= (ImageButton) titlebarView.findViewById(R.id.ib_search_cinema);
        tv_cinema_cinema= (TextView) titlebarView.findViewById(R.id.tv_cinema_cinema);
       /*find页面*/
        tv_find_find= (TextView) titlebarView.findViewById(R.id.tv_find_find);
           /*mine 页面*/
        rl_login_mine= (RelativeLayout) titlebarView.findViewById(R.id.rl_login_mine);
        rb_Login_avatar_mine= (RadioButton) titlebarView.findViewById(R.id.rb_Login_avatar_mine);
        tv_login_mine= (TextView) titlebarView.findViewById(R.id.tv_login_mine);
        ib_others_mine= (ImageButton) titlebarView.findViewById(R.id.ib_others_mine);


        return titlebarView;

    }


    public void initData() {

    }
}
