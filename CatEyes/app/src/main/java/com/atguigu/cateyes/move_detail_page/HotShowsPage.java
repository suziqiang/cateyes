package com.atguigu.cateyes.move_detail_page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.activity.HotShowWebView;
import com.atguigu.cateyes.activity.VideoPlayerActivity;
import com.atguigu.cateyes.bean.HotShowPageForListViewBean;
import com.atguigu.cateyes.bean.HotShowsPageAdBean;
import com.atguigu.cateyes.move_detail_base_page.MoveDetailsBase;
import com.atguigu.cateyes.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class HotShowsPage extends MoveDetailsBase{
   private ImageButton ib_hotshows_search;
    private ViewPager viewpager_hotshows_ad;
    private ListView listview_hotshows;
    private HotShowsPageAdBean hotShowsPageAdBean;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int currentItem = viewpager_hotshows_ad.getCurrentItem();
            if (currentItem < hotShowsPageAdBean.getData().size() - 1) {
                currentItem++;
            } else {
                currentItem = 0;
            }
            viewpager_hotshows_ad.setCurrentItem(currentItem);// 切换到下个页面
            handler.sendEmptyMessageDelayed(0, 3000);//继续延迟3秒发送消息让Handler继续执行 形成循环
        }
    };
    private HotShowPageForListViewBean hotShowPageForListViewBean;
    private SwipeRefreshLayout sw_hotshowspage;
    private MyListAdapter mylistadapter;
    private List<HotShowPageForListViewBean.DataBean.MoviesBean> movies;


    public HotShowsPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        /*主布局*/
        View hotShowsPoageView = View.inflate(context, R.layout.hotshowspage, null);
        listview_hotshows= (ListView) hotShowsPoageView.findViewById(R.id.listview_hotshows);
         sw_hotshowspage = (SwipeRefreshLayout) hotShowsPoageView.findViewById(R.id.sw_hotshowspage);
        /*设置下拉刷新参数*/
          setSw_hotshowspage();
        sw_hotshowspage.setOnRefreshListener(new MyOnRefreshListener());
         /*加载头布局*/
         View topView = View.inflate(context,R.layout.hotshows_top,null);
        ib_hotshows_search= (ImageButton) topView.findViewById(R.id.ib_hotshows_search);
        viewpager_hotshows_ad= (ViewPager) topView.findViewById(R.id.viewpager_hotshows_ad);
        /*viewpager从网络获取数据*/
        getDataFromNet1();
          /*listView从网络获取数据*/
        getDataFromNet2();
        listview_hotshows.addHeaderView(topView);
        /*设置listview的点击监听事件*/
        listview_hotshows.setOnItemClickListener(new MyOnItemClickListener());

        return hotShowsPoageView;
    }

    private void setSw_hotshowspage() {
        //设置下拉多少距离才触发下拉刷新动作
        sw_hotshowspage.setDistanceToTriggerSync(200);
        /*设置下拉控件的颜色*/
        sw_hotshowspage.setColorSchemeColors(Color.RED);
        /*设置下拉刷新控件的背景颜色*/
        sw_hotshowspage.setProgressBackgroundColorSchemeColor(Color.WHITE);


    }
    /*设置swipeRefreshLayout 的下拉刷新监听*/
    private class MyOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                       getDataFromNet2();
                    //设置刷新状态还原-或者说结束
                    sw_hotshowspage.setRefreshing(false);
                    mylistadapter.notifyDataSetChanged();
                }
            }, 4000);
        }
    }

    private void getDataFromNet2() {
        RequestParams params=new RequestParams(Url.HOTSHOW_LISTVIEW);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "我是为listView请求的数据" + result);
                processDataforlistview(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished()");
            }
        });




    }
    /*listView从网络获取数据后解析*/
    private void processDataforlistview(String json) {
         hotShowPageForListViewBean = new Gson().fromJson(json, HotShowPageForListViewBean.class);
         mylistadapter = new MyListAdapter();
       movies = hotShowPageForListViewBean.getData().getMovies();
        listview_hotshows.setAdapter(mylistadapter);


    }

    /*listview中的adapter*/
    private class MyListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return hotShowPageForListViewBean.getData().getMovies().size();
        }

        @Override
        public Object getItem(int position) {
            return  hotShowPageForListViewBean.getData().getMovies().get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                viewHolder=new ViewHolder();
                 convertView = View.inflate(context, R.layout.hotshowspage_item, null);
                viewHolder.iv_hotshowspage_item_icon = (ImageButton) convertView.findViewById(R.id.iv_hotshowspage_item_icon);
                viewHolder.tv_hotshowspage_item_name = (TextView) convertView.findViewById(R.id.tv_hotshowspage_item_name);
                viewHolder.iv_hotshowspage_item_style = (ImageView) convertView.findViewById(R.id.iv_hotshowspage_item_style);
                viewHolder.tv_hotshowspage_item_scm = (TextView) convertView.findViewById(R.id.tv_hotshowspage_item_scm);
                viewHolder.tv_hotshowspage_item_showInfo = (TextView) convertView.findViewById(R.id.tv_hotshowspage_item_showInfo);
                viewHolder.tv_hotshowspage_item_scores = (TextView) convertView.findViewById(R.id.tv_hotshowspage_item_scores);
                viewHolder.bt_hotshowspage_item_buy = (Button) convertView.findViewById(R.id.bt_hotshowspage_item_buy);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

                HotShowPageForListViewBean.DataBean.MoviesBean moviesBean = hotShowPageForListViewBean.getData().getMovies().get(position);
                /*设置电影名称*/
                viewHolder.tv_hotshowspage_item_name.setText(moviesBean.getNm());
                /*设置电影描述*/
                viewHolder.tv_hotshowspage_item_scm.setText(moviesBean.getScm());
                viewHolder.tv_hotshowspage_item_showInfo.setText(moviesBean.getShowInfo());
                 /*设置电影评分*/
                viewHolder.tv_hotshowspage_item_scores.setText(""+moviesBean.getSc());
                /*设置影片格式是否3d*/
                if(moviesBean.isImax()){
                    viewHolder.iv_hotshowspage_item_style.setBackgroundResource(R.drawable.rw);
                }else{
                    viewHolder.iv_hotshowspage_item_style.setBackgroundResource(R.drawable.ru);
                }
                /*设置电影海报*/
                x.image().bind(viewHolder.iv_hotshowspage_item_icon,moviesBean.getImg());
                /*判断是预售还是购票*/
                if(moviesBean.getPreSale() == 1){
                    viewHolder.bt_hotshowspage_item_buy.setText("预售");
                    viewHolder.bt_hotshowspage_item_buy.setTextColor(Color.BLUE);
                    viewHolder.bt_hotshowspage_item_buy.setBackgroundResource(R.drawable.button_background_seclet1);
                    viewHolder.tv_hotshowspage_item_scores.setText(moviesBean.getWish() + "想看");

            }
            viewHolder.iv_hotshowspage_item_icon.setOnClickListener(new MyOnClickListener());
            return convertView;
        }
    }
    static class ViewHolder{
        ImageButton iv_hotshowspage_item_icon;
        TextView tv_hotshowspage_item_name;
        ImageView iv_hotshowspage_item_style;
        TextView tv_hotshowspage_item_scm;
        TextView tv_hotshowspage_item_showInfo;
        TextView tv_hotshowspage_item_scores;
        Button bt_hotshowspage_item_buy;
      RelativeLayout tl_imagebutton;
    }




    private void getDataFromNet1() {
        RequestParams params=new RequestParams(Url.HOTSHOW_AD);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished()");
            }
        });


    }
    /*解析json数据*/
    private void processData(String json) {
        hotShowsPageAdBean = new Gson().fromJson(json, HotShowsPageAdBean.class);
           /*viewpager绑定图片*/
        viewpager_hotshows_ad.setAdapter(new MyPagerAdapter());
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(context);
            String imgUrl = hotShowsPageAdBean.getData().get(position).getImgUrl();
            x.image().bind(imageView,imgUrl);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
          container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return hotShowsPageAdBean.getData().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }


    private class MyOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int idi = movies.get(position).getId();
            String url="http://m.maoyan.com/movie/246188?_v_=yes";
            String prUrl = url.replace("246188", idi+"");
            Intent intent=new Intent(context, HotShowWebView.class);
            intent.putExtra("address",prUrl);
            context.startActivity(intent);
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,VideoPlayerActivity.class);
            context.startActivity(intent);
        }
    }
}