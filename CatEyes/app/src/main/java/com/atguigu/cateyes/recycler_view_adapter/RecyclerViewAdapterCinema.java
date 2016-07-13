package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.JingWei2Distance;
import com.atguigu.cateyes.bean.CinemaBean;

import java.text.DecimalFormat;
import java.util.List;


/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class RecyclerViewAdapterCinema extends RecyclerView.Adapter<RecyclerViewAdapterCinema.ViewHolder> {

    private static final int HEAD_VIEW = 1;
    private static final int BODY_VIEW = 2;
    private final Context content;
    private final List<CinemaBean.BaseBean> datas;
    private final double locType;
    private final double longitude;
    public View headView;


    public RecyclerViewAdapterCinema(Context context, List<CinemaBean.BaseBean> datas, double locType, double longitude) {
        this.content = context;
        this.datas = datas;
        this.locType=locType;
        this.longitude=longitude;

    }

    public void setHeadView(View view) {
        this.headView = view;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        } else {
            return BODY_VIEW;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEAD_VIEW) {
            return new ViewHolder(headView);

        } else {
            View view = LayoutInflater.from(content).inflate(R.layout.listview_cinema, parent, false);
            return new ViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {


        } else {
            CinemaBean.BaseBean baseBean = datas.get(position);
            holder.name_cinema.setText(baseBean.getNm());
            holder.price_cinema.setText(baseBean.getSellPrice() + "元起");
            holder.location_cinema.setText(baseBean.getAddr());

            /*设置距离*/
            double lat = baseBean.lat;
            double lng = baseBean.getLng();
            double distanceOfMeter = JingWei2Distance.getDistanceOfMeter(lat, lng, locType, longitude);
            double v = distanceOfMeter / 1000000;
            DecimalFormat df = new DecimalFormat("0.00");
            String format = df.format(v);
            holder.distance_cinema.setText(format+"公里");
        }


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_cinema;
        private TextView price_cinema;
        private TextView location_cinema;
        private TextView distance_cinema;
        private TextView button_cinema;
        private View topView;

        public ViewHolder(View itemView) {
            super(itemView);
            name_cinema = (TextView) itemView.findViewById(R.id.name_cinema);
            price_cinema = (TextView) itemView.findViewById(R.id.price_cinema);
            location_cinema = (TextView) itemView.findViewById(R.id.location_cinema);
            distance_cinema = (TextView) itemView.findViewById(R.id.distance_cinema);
            button_cinema = (TextView) itemView.findViewById(R.id.button_cinema);

        }
    }





}