package com.atguigu.cateyes.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.atguigu.cateyes.R;
import com.atguigu.cateyes.bean.CinemaBean;
import com.atguigu.cateyes.bean.FindViewPageBean;
import com.atguigu.cateyes.item_decoration.DividerListItemDecoration;
import com.atguigu.cateyes.recycler_view_adapter.RecyclerViewAdapterCinema;
import com.atguigu.cateyes.url.Url;
import com.atguigu.cateyes.volley.VolleyManager;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class CinemaView {
    private Context context;
    public View rootView;
    private  AutoScrollViewPager viewpager_cinema;
    @ViewInject(R.id.button_cinema_enter)
    private Button button_cinema_enter;
    private List<CinemaBean.BaseBean> changping;
    private RecyclerViewAdapterCinema recyclerviewadaptercinema;
    private View topView;
    private RecyclerView re_vi_cinema;
    private List<FindViewPageBean.DataBean> viewPagerData;
      TextView tv_location_cinema;



    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private String position;
    public  double locType;
    public double longitude;

    public CinemaView(Context context){
        this.context=context;
        rootView=initView();

        mLocationClient = new LocationClient(context);     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        initLocation();
      /*开始定位*/
        mLocationClient.start();

    }

    private View initView() {
         topView = View.inflate(context, R.layout.page_cinema, null);
          viewpager_cinema= (AutoScrollViewPager) topView.findViewById(R.id.viewpager_cinema);
        View mainView = LayoutInflater.from(context).inflate(R.layout.main_cinema, null);
         re_vi_cinema = (RecyclerView) mainView.findViewById(R.id.re_vi_cinema);

        tv_location_cinema= (TextView) mainView.findViewById(R.id.tv_location_cinema);

        return mainView;
    }
    public void initData(){
        /*请求网络数据*/
        getDataOfListViewFromNet();

        getDataOfViewPager();
    }

    private void getDataOfViewPager() {
        RequestParams params=new RequestParams(Url.FIND_ViewPager);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                /*解析listView 的数据*/
                processDataOfviewPager(result);
                Log.e("iii", "cinema获取viewpager数据成功=============" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    private void processDataOfviewPager(String json) {

        FindViewPageBean findViewPageBean = new Gson().fromJson(json, FindViewPageBean.class);
        viewPagerData = findViewPageBean.getData();

         /*设置ViewPage的Adapter*/
        viewpager_cinema.setAdapter(new MyViewPageAdapter());
        Log.e("iii", "processDataOfviewPager===" + viewPagerData);
    }

    private void getDataOfListViewFromNet() {
        StringRequest request=new StringRequest(Request.Method.GET, Url.CINEMA_LISTVIEW, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                LogUtil.e("Volley联网成功==" + s);
               /*解析listview的数据*/
                processDataOfListView(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.e("Volley请求失败==" + volleyError.getMessage());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
               /*解决乱码*/
                try {
                    String parsed = new String(response.data,"UTF-8");
                    return  Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                return super.parseNetworkResponse(response);
            }
        };
        //把请求的数据加入到队列中
        VolleyManager.getRequestQueue().add(request);
    }
    /*解析listview的数据*/
    private void processDataOfListView(String json) {
         CinemaBean cinemabean = new Gson().fromJson(json, CinemaBean.class);
         changping = cinemabean.getData().getChangping();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false);
        Log.e("aaa", re_vi_cinema.toString());

        re_vi_cinema.setLayoutManager(linearLayoutManager);
          re_vi_cinema.addItemDecoration(new DividerListItemDecoration(context, LinearLayoutManager.VERTICAL));

        recyclerviewadaptercinema = new RecyclerViewAdapterCinema(context, changping,locType,longitude);
        recyclerviewadaptercinema.setHeadView(topView);

        re_vi_cinema.setAdapter(recyclerviewadaptercinema);
        viewpager_cinema.startAutoScroll();


    }


    private class MyViewPageAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(context, R.layout.cinema_viewpager_item, null);
            ImageView iv_viewpager_cinema= (ImageView) view.findViewById(R.id.iv_viewpager_cinema);

            x.image().bind(iv_viewpager_cinema,viewPagerData.get(position).getImgUrl());
            Log.e("iii", viewPagerData.get(position).getImgUrl());
            container.addView(view);
            Log.e("iii", "==========================================================================");
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return viewPagerData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }


    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("qqq", sb.toString());
            Log.e("qqq", location.getAddrStr() + location.getLocationDescribe());
             position = location.getAddrStr() + "" + location.getLocationDescribe();
             tv_location_cinema.setText(position);
             locType = location.getLocType();
             longitude = location.getLongitude();
        }
    }

    public double getLocType() {
        return locType;
    }

    public void setLocType(double locType) {
        this.locType = locType;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
