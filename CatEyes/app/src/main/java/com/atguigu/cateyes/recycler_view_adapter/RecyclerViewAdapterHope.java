package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.cateyes.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/26 0026.
 */
public class RecyclerViewAdapterHope extends RecyclerView.Adapter<RecyclerViewAdapterHope.MyViewHolder> {
    private  Context context;
    private  List<String> datas;

    public RecyclerViewAdapterHope(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.recyclerview_hope_item, null);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_recyclerview_hope_describe.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
          TextView tv_recyclerview_hope_describe;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_recyclerview_hope_describe= (TextView) itemView.findViewById(R.id.tv_recyclerview_hope_describe);
        }
    }
}
