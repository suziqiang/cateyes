package com.atguigu.cateyes.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.sore.ShoppingMall;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class MineView {
    private Context context;

    public MineView(Context context){
        this.context=context;

    }
    public View initView(){
        View mineView = View.inflate(context, R.layout.page_mine, null);
        RelativeLayout rl_mine_store= (RelativeLayout) mineView.findViewById(R.id.rl_mine_store);
        /*给商城设置监听*/
        rl_mine_store.setOnClickListener(new MyOnClickListener());
        return mineView ;
    }


    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, ShoppingMall.class);
            context.startActivity(intent);
        }
    }
}
