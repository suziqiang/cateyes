package com.atguigu.cateyes.move_detail_base_page;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public abstract class MoveDetailsBase {
    public View rootView;
    public Context context;

    public MoveDetailsBase(Context context){
        this.context=context;
         rootView = initView();
    }
    public abstract View initView();

     public  void initData(){


   }
}
