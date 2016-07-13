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
public class RecyclerViewAdapterPrevue extends RecyclerView.Adapter<RecyclerViewAdapterPrevue.MyViewHolder> {
    private  List<String> datas;
    private Context context;
    public RecyclerViewAdapterPrevue(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.recyclerview_prevue_item, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_recyclerview_describe.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_recyclerview_describe;

        public MyViewHolder(View itemView) {
            super(itemView);
        tv_recyclerview_describe = (TextView) itemView.findViewById(R.id.tv_recyclerview_describe);


        }
    }

}
