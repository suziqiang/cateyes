package com.atguigu.cateyes.popu_window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.atguigu.cateyes.R;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class Popu {

    private final Context context;
    private final RelativeLayout rl_checkbox;
    public  PopupWindow mPopWindow;

    public Popu(Context context, RelativeLayout rl_checkbox){
        this.context=context;
        this.rl_checkbox=rl_checkbox;
        View contentView = LayoutInflater.from(context).inflate(R.layout.store_popu_window_item, null);
         mPopWindow = new PopupWindow(contentView);
    }

    public void showPopupWindow() {

        mPopWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        mPopWindow.showAsDropDown(rl_checkbox,0,10);

    }
    public void dismiss(){

            mPopWindow.dismiss();


    }
}
