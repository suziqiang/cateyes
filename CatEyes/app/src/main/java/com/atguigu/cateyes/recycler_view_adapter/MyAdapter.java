package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.City;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class MyAdapter extends BaseAdapter {
    private final List<City> datas;
    private Context context;

    public MyAdapter(Context context, List<City> datas){
        this.context=context;
        this.datas=datas;

    }


    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView==null){
            viewholder=new ViewHolder();
            convertView= View.inflate(context, R.layout.item_check_city, null);
            viewholder.tv_word= (TextView) convertView.findViewById(R.id.tv_word);
            viewholder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) convertView.getTag();
        }

        City city = datas.get(position);
        Log.e("a",city.toString());
        String substring = city.getPinYin().substring(0,1);
        viewholder.tv_word.setText(substring);
        viewholder.tv_name.setText(city.getName());
        if(position ==0){
            viewholder.tv_word.setVisibility(View.VISIBLE);
        }else{
            //得到前一个位置对应的字母，如果当前的字母和上一个相同，隐藏；否则就显示
            String preWord = datas.get(position-1).getPinYin().substring(0,1);//A~Z
            if(substring.equals(preWord)){
                viewholder.tv_word.setVisibility(View.GONE);
            }else{
                viewholder.tv_word.setVisibility(View.VISIBLE);
            }


        }

        return convertView;
    }
    static class ViewHolder{
        TextView tv_word;
        TextView tv_name;
    }
}
