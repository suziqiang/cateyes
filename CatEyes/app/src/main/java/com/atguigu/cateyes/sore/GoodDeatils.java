package com.atguigu.cateyes.sore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.DensityUtil;
import com.atguigu.cateyes.bean.GoodDeatilsBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class GoodDeatils extends Activity implements View.OnClickListener {
    private String url;
    private GoodDeatilsBean.DataBean data;
    private AutoScrollViewPager viewpager_shoppingcar_icon;
    private LinearLayout ll_add_point;
    private int prePosition=0;
    private ImageView iv_shoppingcart_back;
    private TextView tv_shopping_name;
    private TextView tv_shopping_price;
    private TextView tv_shopping_value;
    private TextView tv_shopping_baozhang;
    private TextView tv_shopping_fahuo_time;
    private Button bt_shopping_qianggou;
    private GoodDeatilsBean goodDeatilsBean;

    private void initView() {
         iv_shoppingcart_back= (ImageView) findViewById(R.id.iv_shoppingcart_back);
         viewpager_shoppingcar_icon= (AutoScrollViewPager) findViewById(R.id.viewpager_shoppingcar_icon);
         ll_add_point= (LinearLayout)findViewById(R.id.ll_add_point1);
         tv_shopping_name= (TextView) findViewById(R.id.tv_shopping_name);
         tv_shopping_price= (TextView) findViewById(R.id.tv_shopping_price);
         tv_shopping_value= (TextView) findViewById(R.id.tv_shopping_value);
         tv_shopping_fahuo_time= (TextView) findViewById(R.id.tv_shopping_fahuo_time);
         tv_shopping_baozhang= (TextView) findViewById(R.id.tv_shopping_baozhang);
        RelativeLayout rl_shopping_check_type_and_number= (RelativeLayout) findViewById(R.id.rl_shopping_check_type_and_number);
         bt_shopping_qianggou= (Button) findViewById(R.id.bt_shopping_qianggou);

        iv_shoppingcart_back.setOnClickListener(this);
        bt_shopping_qianggou.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        getDataFromNet();

    }

    private void getDataFromNet() {
        RequestParams params=new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("dd", "GoodDeatils=====获取数据成功" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("dd", "GoodDeatils=====获取数据错误" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("dd", "GoodDeatils=====获取数据成功" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("dd", "GoodDeatils=====获取数据成功 onFinished()");
            }
        });

    }

    private void processData(String json) {
         goodDeatilsBean = new Gson().fromJson(json, GoodDeatilsBean.class);
        data = goodDeatilsBean.getData();
        Log.e("dd", "GoodDeatils=====解析数据成功"+data);
        /*绑定数据*/
        bindData();
        /*增加红底*/
        addPoint();
        viewpager_shoppingcar_icon.setAdapter(new MyPageAdapter());
        viewpager_shoppingcar_icon.startAutoScroll();
    }

    private void bindData() {
        tv_shopping_name.setText(data.getTitle());
        tv_shopping_price.setText(data.getPrice()+"");
        tv_shopping_value.setText(data.getValue() + "");
        tv_shopping_fahuo_time.setText(data.getNotes());
        int size = data.getServicePromise().size();
        String s1=" ";
        for(int x=0;x<size;x++){
             String s = data.getServicePromise().get(x);
            s1=s+" "+s1;
        }
        tv_shopping_baozhang.setText(s1+",");

    }

    private void addPoint() {
        //把所有的点先移除
        ll_add_point.removeAllViews();
        //设置红点和文本
        for(int i=0;i<data.getTopPics().size();i++){

            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_bg_selector);
            if(i==0){
                point.setEnabled(true);
            }else{
                point.setEnabled(false);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(this, 5),DensityUtil.dip2px(this,5));
            if(i != 0){
                params.leftMargin = DensityUtil.dip2px(this, 5);
            }
            point.setLayoutParams(params);

            //添加到显示布局里面
            ll_add_point.addView(point);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_shopping_qianggou:

                Intent intent=new Intent(GoodDeatils.this,CommitOrder.class);
                Bundle bundle =new Bundle();
                bundle.putSerializable("data",data);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.iv_shoppingcart_back:
                finish();
                break;
        }


    }


    private class MyPageAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
              ImageView imageView=new ImageView(GoodDeatils.this);
            x.image().bind(imageView,data.getTopPics().get(position));
            container.addView(imageView);
            viewpager_shoppingcar_icon.addOnPageChangeListener(new MyOnPageChangeListener());
            return imageView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return data.getTopPics().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //1.把上一次的设置默认
            ll_add_point.getChildAt(prePosition).setEnabled(false);
            //2.把当前页面对应的点设置高亮
            ll_add_point.getChildAt(position).setEnabled(true);
            prePosition = position;
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
