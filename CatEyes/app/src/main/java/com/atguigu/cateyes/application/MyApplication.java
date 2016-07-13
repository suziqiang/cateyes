package com.atguigu.cateyes.application;

import android.app.Application;

import com.atguigu.cateyes.volley.VolleyManager;
import com.umeng.socialize.PlatformConfig;

import org.xutils.x;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        VolleyManager.init(this);
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
    }
}
