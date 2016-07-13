package com.atguigu.cateyes.country_movie_base_page;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public abstract class CountryMoveBase {
    public Context context;
    public View rootView;
    public CountryMoveBase(Context context){
        this.context=context;
        rootView=initView();

    }

    public abstract View initView();
    public void initData(){

    }


}
