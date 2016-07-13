package com.atguigu.cateyes.sore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.ShoppingCart.ShoppingCart;
import com.atguigu.cateyes.Untils.CartProvider;
import com.atguigu.cateyes.Untils.NumberAddSubView;
import com.atguigu.cateyes.bean.GoodDeatilsBean;
import com.atguigu.cateyes.bean.ShoppingCartBean;

import org.xutils.x;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class CommitOrder extends Activity implements View.OnClickListener {


    private GoodDeatilsBean.DataBean data;
    private ImageView iv_commitorder_good_icon;
    private TextView tv_commitorder_good_name;
    private TextView tv_commitorder_good_unit_price;
    private TextView tv_commitorder_good_style;
    private ImageView iv_commitorder_back;
    private NumberAddSubView tv_commitorder_good_add_reduce;
    private TextView tv_commitorder_good_state_number;
    private TextView tv_commitorder_good_total_num;
    private TextView tv_commitorder_good_total_price;
    private TextView tv_commitorder_good_order_total_price;
    private Button bt_shopping_submit_order;
    private CartProvider cartProvider;

    private void initView() {
         iv_commitorder_back= (ImageView) findViewById(R.id.iv_commitorder_back);
         iv_commitorder_good_icon= (ImageView) findViewById(R.id.iv_commitorder_good_icon);
         tv_commitorder_good_name= (TextView) findViewById(R.id.tv_commitorder_good_name);
        tv_commitorder_good_unit_price= (TextView) findViewById(R.id.tv_commitorder_good_unit_price);
         tv_commitorder_good_state_number= (TextView) findViewById(R.id.tv_commitorder_good_state_number);
         tv_commitorder_good_style= (TextView) findViewById(R.id.tv_commitorder_good_style);
         tv_commitorder_good_total_num= (TextView) findViewById(R.id.tv_commitorder_good_total_num);
         tv_commitorder_good_total_price= (TextView) findViewById(R.id.tv_commitorder_good_total_price);
         tv_commitorder_good_order_total_price= (TextView) findViewById(R.id.tv_commitorder_good_order_total_price);
        TextView tv_commitorder_write_address= (TextView) findViewById(R.id.tv_commitorder_write_address);
         bt_shopping_submit_order= (Button) findViewById(R.id.bt_shopping_submit_order);
         tv_commitorder_good_add_reduce= (NumberAddSubView) findViewById(R.id.tv_commitorder_good_add_reduce);
          /*返回设置监听*/
        iv_commitorder_back.setOnClickListener(this);
        /*监听增加 减少的个数*/
        tv_commitorder_good_add_reduce.setOnButtonClickListener(new MyOnButtonClickListener());
        bt_shopping_submit_order.setOnClickListener(this);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.commitorder);
//        cartProvider= CartProvider.getInstance(CommitOrder.this);
        initView();
        initData();

    }

    private void initData() {
         Intent intent = getIntent();
         data = (GoodDeatilsBean.DataBean) intent.getSerializableExtra("data");
         Log.e("ddd", data.getPrice() + "");
             bindData();
    }

    private void bindData() {
        x.image().bind(iv_commitorder_good_icon, data.getBuyPic());
        tv_commitorder_good_name.setText(data.getTitle());
        if(data!=null){
            tv_commitorder_good_unit_price.setText(data.getPrice()+"");
        }
        tv_commitorder_good_style.setText(data.getTitle());
        /*得到控件上的默认个数*/
        int num = tv_commitorder_good_add_reduce.getValue();
        /*tv_commitorder_good_state_number.setText(num+"");
        *//*得到总个数*//*
        tv_commitorder_good_total_num.setText(num+"");
        //得到价格
        float totalrice= data.getPrice() * num;
        tv_commitorder_good_total_price.setText(totalrice+"");
        tv_commitorder_good_order_total_price.setText(""+totalrice);*/
        setPriceAndNumber(num);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_commitorder_back:
                finish();
                break;
            case R.id.bt_shopping_submit_order:
                Intent intent=new Intent(CommitOrder.this, ShoppingCart.class);
                /*本地缓存*/
                cartProvider = new CartProvider(CommitOrder.this);
                ShoppingCartBean car = cartProvider.conversion(data);
                cartProvider.update(car);
                startActivity(intent);

        }

    }

    private class MyOnButtonClickListener implements NumberAddSubView.OnButtonClickListener {
        @Override
        public void onSubButton(View view, int value) {
            Log.e("vvv", "SubButton得到的个数是=======================" + value);

         /*   tv_commitorder_good_state_number.setText("" + value);
            tv_commitorder_good_total_num.setText(value+"");
            float totalrice= data.getPrice() * value;
            tv_commitorder_good_total_price.setText(totalrice+"");*/
            setPriceAndNumber(value);
        }

        @Override
        public void onAddButton(View view, int value) {
            Log.e("vvv", "AddButton得到的个数是=======================" + value);

            setPriceAndNumber(value);
        }
}

    private void setPriceAndNumber(int number) {
        tv_commitorder_good_state_number.setText(""+number);
        tv_commitorder_good_total_num.setText(number+"");
        float totalrice= data.getPrice() * number;
        tv_commitorder_good_total_price.setText(totalrice+"");
        tv_commitorder_good_order_total_price.setText(""+totalrice);
    }


}
