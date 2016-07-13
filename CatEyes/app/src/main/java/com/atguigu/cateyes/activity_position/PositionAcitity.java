package com.atguigu.cateyes.activity_position;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.City;
import com.atguigu.cateyes.recycler_view_adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PositionAcitity extends Activity {


    public  static final int RESULT_CODE =1;
    private MyLetterView myLetterView;
    private TextView tvDialog;
    private ListView listview_checkcity;
     private List<City> datas;
    private ImageButton ib_back_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        myLetterView=(MyLetterView) findViewById(R.id.my_letterview);
        /*初始化数据*/
        tvDialog=(TextView) findViewById(R.id.tv_dialog);
        listview_checkcity = (ListView) findViewById(R.id.listview_checkcitty);
         ib_back_move = (ImageButton) findViewById(R.id.ib_back_move);

        //将中间展示字母的TextView传递到myLetterView中并在其中控制它的显示与隐藏
        myLetterView.setTextView(tvDialog);
        //注册MyLetterView中监听(跟setOnClickListener这种系统默认写好的监听一样只不过这里是我们自己写的)
              initData();
        myLetterView.setOnSlidingListener(new MyLetterView.OnSlidingListener() {
            @Override
            public void sliding(String str) {
                tvDialog.setText(str);
                    for(int i=0;i<datas.size();i++){
                        String listWord = datas.get(i).getPinYin().substring(0,1);//YANGGUANGFU-->Y
                        if (str.equals(listWord)) {
                            //i是listView中的位置
                            listview_checkcity.setSelection(i);//定位到ListVeiw中的某个位置
                            return;
                        }
                    }


            }
        });

        listview_checkcity.setAdapter(new MyAdapter(this, datas));
        ib_back_move.setOnClickListener(new MyOnClickListener());
        listview_checkcity.setOnItemClickListener(new MyOnItemClickListener());

    }

    private void initData() {
        datas=new ArrayList<>();
        datas.add(new City("北京市"));
        datas.add(new City("重庆市"));
        datas.add(new City("上海市"));
        datas.add(new City("石家庄市"));
        datas.add(new City("天津市"));
        datas.add(new City("哈尔滨市"));
        datas.add(new City("双城市"));
        datas.add(new City("武昌市"));
        datas.add(new City("白山市"));
        datas.add(new City("松原市"));
        datas.add(new City("行唐市"));
        datas.add(new City("赵州市"));
        datas.add(new City("连云港市"));
        datas.add(new City("南昌市"));
        datas.add(new City("辛集市"));
        datas.add(new City("武昌市"));
        datas.add(new City("平山市"));
        datas.add(new City("锦州市"));
        datas.add(new City("南京市"));


        //排序
        Collections.sort(datas, new Comparator<City>() {
            @Override
            public int compare(City lhs, City rhs) {
                return lhs.getPinYin().compareTo(rhs.getPinYin());
            }
        });


    }

/*设置返回箭头的监听*/
    private class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        finish();
    }
}

    private class MyOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String cityName = datas.get(position).getName();
            Intent intent = getIntent();
            intent.putExtra("cityname",cityName);
            setResult(RESULT_CODE, intent);
            finish();

        }
    }
}
