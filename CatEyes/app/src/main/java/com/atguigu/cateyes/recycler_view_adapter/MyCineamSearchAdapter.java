package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.JingWei2Distance;
import com.atguigu.cateyes.bean.CinemaSearchBean;
import com.atguigu.cateyes.view.CinemaView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class MyCineamSearchAdapter extends RecyclerView.Adapter<MyCineamSearchAdapter.MyViewHolder>{
    private final Context context;
    private final List<CinemaSearchBean.DataBean> data;

    public MyCineamSearchAdapter(Context context, List<CinemaSearchBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.search_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CinemaSearchBean.DataBean dataBean = data.get(position);
        holder.name_cinema_search.setText(dataBean.getNm());
        holder.price_cinema_search.setText(dataBean.getSellPrice());
        holder.location_cinema_search.setText(dataBean.getAddr());
        CinemaView cinemaView=new CinemaView(context);

        double locType = cinemaView.getLocType();
        double longitude = cinemaView.getLongitude();
        double lat = dataBean.getLat();
        double lng = dataBean.getLng();
        double distanceOfMeter = JingWei2Distance.getDistanceOfMeter(lat, lng, locType, longitude);
        double v = distanceOfMeter / 1000;
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(v);
        holder.distance_cinema_search.setText(format+"km");




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_cinema_search;
        private TextView price_cinema_search;
        private TextView location_cinema_search;
        private TextView distance_cinema_search;

        public MyViewHolder(View itemView) {
            super(itemView);
            name_cinema_search= (TextView) itemView.findViewById(R.id.name_cinema_search);
            price_cinema_search= (TextView) itemView.findViewById(R.id.price_cinema_search);
            location_cinema_search= (TextView) itemView.findViewById(R.id.location_cinema_search);
            distance_cinema_search= (TextView) itemView.findViewById(R.id.distance_cinema_search);

        }
    }
}
