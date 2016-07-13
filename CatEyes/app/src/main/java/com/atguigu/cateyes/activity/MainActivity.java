package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.activity_position.PositionAcitity;
import com.atguigu.cateyes.main_page.CinemaPage;
import com.atguigu.cateyes.main_page.FindPage;
import com.atguigu.cateyes.main_page.MinePage;
import com.atguigu.cateyes.main_page.MovePage;

public class MainActivity extends Activity {
    private FrameLayout fl_mainactivity;
    private RadioGroup rg_mainactivity;
    private RadioButton rb_mainactivity_move;
    private RadioButton rb_mainactivity_cinema;
    private RadioButton rb_mainactivity_find;
    private RadioButton rb_mainactivity_mine;
    private MovePage movePage;
    private CinemaPage cinemaPage;
    private MinePage minePage;
    private FindPage findPage;
    private static final int REQUEST_CODE = 1;
    private PopupWindow mPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据 加载子布局
        initialize();
    }

    private void initialize() {
        /*布局控件实例化*/
        fl_mainactivity = (FrameLayout) findViewById(R.id.fl_mainactivity);
        rg_mainactivity = (RadioGroup) findViewById(R.id.rg_mainactivity);
        rb_mainactivity_move = (RadioButton) findViewById(R.id.rb_mainactivity_move);
        rb_mainactivity_cinema = (RadioButton) findViewById(R.id.rb_mainactivity_cinema);
        rb_mainactivity_find = (RadioButton) findViewById(R.id.rb_mainactivity_find);
        rb_mainactivity_mine = (RadioButton) findViewById(R.id.rb_mainactivity_mine);
       /*各个主页面加载*/
        movePage = new MovePage(this);
        cinemaPage = new CinemaPage(this);
        findPage = new FindPage(this);
        minePage = new MinePage(this);
        /*默认加载move页面*/
        fl_mainactivity.addView(movePage.rootview);
        /*给RadioGroup设置监听事件*/
        rg_mainactivity.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        /*给北京设置点击监听*/
        movePage.tv_beijing_movepage.setOnClickListener(new MyonOnClickListener());
        cinemaPage.tv_beijing_movepage.setOnClickListener(new MyonOnClickListener());
        cinemaPage.ib_screen_cinema.setOnClickListener(new MyonOnClickListener());
        initData();
    }

    private void initData() {
        movePage.initData();
        cinemaPage.initData();
        findPage.initData();
        minePage.initData();
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_mainactivity_move:
                    fl_mainactivity.removeAllViews();
                    fl_mainactivity.addView(movePage.rootview);
                    break;
                case R.id.rb_mainactivity_cinema:
                    fl_mainactivity.removeAllViews();
                    fl_mainactivity.addView(cinemaPage.rootview);
                    break;
                case R.id.rb_mainactivity_find:
                    fl_mainactivity.removeAllViews();
                    fl_mainactivity.addView(findPage.rootview);
                    break;
                case R.id.rb_mainactivity_mine:
                    fl_mainactivity.removeAllViews();
                    fl_mainactivity.addView(minePage.rootview);
                    break;
            }
        }
    }

    private class MyonOnClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id==R.id.tv_beijing_movepage) {
                Intent intent = new Intent(MainActivity.this, PositionAcitity.class);
                MainActivity.this.startActivityForResult(intent, REQUEST_CODE);
            } else if (id==R.id.ib_screen_cinema) {
                showPopupWindow();
            }

        }
    }

    /*加载popuwindow*/
    private void showPopupWindow() {

        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popu_window_item, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        mPopWindow.showAsDropDown(cinemaPage.ib_screen_cinema);


    }

       /*intent回调方法*/

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == REQUEST_CODE) {
            if (resultCode == PositionAcitity.RESULT_CODE) {
                String cityname = data.getStringExtra("cityname");
                movePage.tv_beijing_movepage.setText(cityname);
            }
        }
    }


}
