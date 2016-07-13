package com.atguigu.cateyes.sore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.ShoppingCart.ShoppingCart;
import com.atguigu.cateyes.activity.StoreHeadActivity;
import com.atguigu.cateyes.activity.StoreWeb;
import com.atguigu.cateyes.bean.StoreMyLoveBean;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.x;

import java.util.List;

public class ShoppingMall extends Activity implements View.OnClickListener {
    private GridView gridView_first;
    private String[] name;
    private int[] icon;
    private ImageView iv_store_back;
    private RelativeLayout rl_store_first;
    private RelativeLayout rl_store_four;
    private RelativeLayout rl_store_seven;
    private LinearLayout ll_store_second;
    private LinearLayout ll_store_three;
    private LinearLayout ll_store_five;
    private LinearLayout ll_store_six;
    private LinearLayout ll_store_eigth;
    private LinearLayout ll_store_nine;

    private GridView gv_store_two;
    private List<StoreMyLoveBean.DataBean.ListBean> list;
    private TextView gouwuche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_mall);
        /*加载gridView_first的数据*/
        initData();
        /*初始化数据*/
        initId();


    }

    private void initId() {
        gridView_first = (GridView) findViewById(R.id.gv_store_first);
        gridView_first.setAdapter(new gridViewFirstAdapter());

        gv_store_two = (GridView) findViewById(R.id.gv_store_two);
        gv_store_two.setAdapter(new gridViewSecondAdapter());

        rl_store_first = (RelativeLayout) findViewById(R.id.rl_store_first);
        rl_store_four = (RelativeLayout) findViewById(R.id.rl_store_four);
        rl_store_seven = (RelativeLayout) findViewById(R.id.rl_store_seven);
        ll_store_second = (LinearLayout) findViewById(R.id.ll_store_second);
        ll_store_three = (LinearLayout) findViewById(R.id.ll_store_three);
        ll_store_five = (LinearLayout) findViewById(R.id.ll_store_five);
        ll_store_six = (LinearLayout) findViewById(R.id.ll_store_six);
        ll_store_eigth = (LinearLayout) findViewById(R.id.ll_store_eigth);
        ll_store_nine = (LinearLayout) findViewById(R.id.ll_store_nine);
        gouwuche= (TextView) findViewById(R.id.gouwuche);

        /*退出当前页置监听*/
        iv_store_back = (ImageView) findViewById(R.id.iv_store_back);
        iv_store_back.setOnClickListener(this);
        rl_store_first.setOnClickListener(this);
        ll_store_second.setOnClickListener(this);
        ll_store_three.setOnClickListener(this);
        rl_store_four.setOnClickListener(this);
        ll_store_five.setOnClickListener(this);
        ll_store_six.setOnClickListener(this);
        rl_store_seven.setOnClickListener(this);
        ll_store_eigth.setOnClickListener(this);
        ll_store_nine.setOnClickListener(this);
        gouwuche.setOnClickListener(this);
        /*为头上的十个图标设置监听*/
        gridView_first.setOnItemClickListener(new MyOnItemClickListener());


    }

    private void initData() {
        name = new String[]{"数码", "高玩专区", "玩具", "生活", "服饰", "超蝙", "机器猫", "魔兽", "美队", "星球大战"};
        icon = new int[]{R.drawable.a01, R.drawable.a02, R.drawable.a03, R.drawable.a04, R.drawable.a05, R.drawable.a06,
                R.drawable.a07, R.drawable.a08, R.drawable.a09, R.drawable.a10};
        StoreMyLoveBean storeMyLoveBean= new Gson().fromJson(Url.json, StoreMyLoveBean.class);
         list = storeMyLoveBean.getData().getList();
    }

    /*设置点击监听*/
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ShoppingMall.this, StoreWeb.class);
        switch (v.getId()) {
            case R.id.iv_store_back:
                finish();
                break;
            case R.id.rl_store_first:
                intent.putExtra("address", Url.STORE_FIRST);
                intent.putExtra("name", "神龟与藏獒");
                startActivity(intent);
                break;
            case R.id.ll_store_second:
                intent.putExtra("address", Url.STORE_SECOND);
                intent.putExtra("name", "尖货精选");
                startActivity(intent);
                break;
            case R.id.ll_store_three:
                intent.putExtra("address", Url.STORE_THREE);
                intent.putExtra("name", "限量特惠");
                startActivity(intent);
                break;
            case R.id.rl_store_four:
                intent.putExtra("address", Url.STORE_FORTH);
                intent.putExtra("name", "DC战队");
                startActivity(intent);
                break;
            case R.id.ll_store_five:
                intent.putExtra("address", Url.STORE_FIVE);
                intent.putExtra("name", "漫威联盟");
                startActivity(intent);
                break;
            case R.id.ll_store_six:
                intent.putExtra("address", Url.STORE_SIX);
                intent.putExtra("name", "疯狂动物城");
                startActivity(intent);
                break;
            case R.id.rl_store_seven:
                intent.putExtra("address", Url.STORE_SEVEN);
                intent.putExtra("name", "3D眼睛");
                startActivity(intent);
                break;
            case R.id.ll_store_eigth:
                intent.putExtra("address", Url.STORE_EIGHT);
                intent.putExtra("name", "童装");
                startActivity(intent);
                break;
            case R.id.ll_store_nine:
                intent.putExtra("address", Url.STORE_NINE);
                intent.putExtra("name", "魔幻T恤");
                startActivity(intent);

            case R.id.gouwuche:
                Intent intent3=new Intent(ShoppingMall.this, ShoppingCart.class);
                startActivity(intent3);
                break;

        }

    }

    private class gridViewFirstAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return name[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewholder;
            if (convertView == null) {
                viewholder = new ViewHolder();
                convertView = View.inflate(ShoppingMall.this, R.layout.shop_first_gridview_item, null);
                viewholder.iv_store_icon = (ImageView) convertView.findViewById(R.id.iv_store_icon);
                viewholder.tv_store_name = (TextView) convertView.findViewById(R.id.tv_store_name);
                convertView.setTag(viewholder);
            } else {
                viewholder = (ViewHolder) convertView.getTag();
            }

            viewholder.iv_store_icon.setBackgroundResource(icon[position]);
            viewholder.tv_store_name.setText(name[position]);
            return convertView;
        }
    }

    static class ViewHolder {
        ImageView iv_store_icon;
        TextView tv_store_name;

            ImageView iv_gridview_second_item_icon;
            TextView tv_gridview_second_item_describe;
            TextView tv_gridview_second_item_price;

    }


    private class gridViewSecondAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewholder;
            if (convertView == null) {
                viewholder=new ViewHolder();
                convertView= View.inflate(ShoppingMall.this, R.layout.shop_second_gridview_item, null);
                viewholder.iv_gridview_second_item_icon= (ImageView) convertView.findViewById(R.id.iv_gridview_second_item_icon);
                viewholder.tv_gridview_second_item_describe= (TextView) convertView.findViewById(R.id.tv_gridview_second_item_describe);
                viewholder.tv_gridview_second_item_price= (TextView) convertView.findViewById(R.id.tv_gridview_second_item_price);
                convertView.setTag(viewholder);
            }else{
                viewholder= (ViewHolder) convertView.getTag();
            }
            StoreMyLoveBean.DataBean.ListBean listBean = list.get(position);
            x.image().bind( viewholder.iv_gridview_second_item_icon,listBean.getPic());
            viewholder.tv_gridview_second_item_describe.setText(listBean.getTitle());
            viewholder.tv_gridview_second_item_price.setText(listBean.getPrice()+"元");

            return convertView;
        }
    }

    private class MyOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(ShoppingMall.this, StoreHeadActivity.class);
            switch (position){
                case 0:
                    intent.putExtra("name","0");
                   intent.putExtra("url",Url.STORE_HEAD_FIRST);
                    startActivity(intent);
                    break;
                case 1:
                    intent.putExtra("name","1");
                   intent.putExtra("url",Url.STORE_HEAD_SECOND);
                    startActivity(intent);
                    break;
                case 2:
                    intent.putExtra("name","2");
                   intent.putExtra("url",Url.STORE_HEAD_THREE);
                    startActivity(intent);
                    break;
                case 3:
                    intent.putExtra("name","3");
                   intent.putExtra("url",Url.STORE_HEAD_FOUR);
                    startActivity(intent);
                    break;
                case 4:
                    intent.putExtra("name","4");
                   intent.putExtra("url",Url.STORE_HEAD_FIVE);
                    startActivity(intent);
                    break;
                case 5:
                    intent.putExtra("name","5");
                   intent.putExtra("url",Url.STORE_HEAD_SIX);
                    startActivity(intent);
                    break;
                case 6:
                    intent.putExtra("name","6");
                   intent.putExtra("url",Url.STORE_HEAD_SEVEN);
                    startActivity(intent);
                    break;
                case 7:
                    intent.putExtra("name","7");
                   intent.putExtra("url",Url.STORE_HEAD_EIGHT);
                    startActivity(intent);
                    break;
                case 8:
                    intent.putExtra("name","8");
                   intent.putExtra("url",Url.STORE_HEAD_NINE);
                    startActivity(intent);
                    break;
                case 9:
                    intent.putExtra("name","9");
                   intent.putExtra("url",Url.STORE_HEAD_TEN);
                    startActivity(intent);
                    break;
            }
        }
    }
}

