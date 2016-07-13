package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.atguigu.cateyes.R;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
public class HotShowWebView extends Activity{
    private WebView hot_show_webview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_show_webview);
        hot_show_webview= (WebView) findViewById(R.id.hot_show_webview);
        setWebView();
        goneWeb();
    }
    private void goneWeb() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("address");
        hot_show_webview.loadUrl(url);


    }
    private void setWebView() {
        WebSettings settings = hot_show_webview.getSettings();
        //设置WebView支持javaScript
        settings.setJavaScriptEnabled(true);
        //用户双击页面页面变大变小-页面要支持才可以
        settings.setUseWideViewPort(true);
        //增加缩放按钮 --页面要支持才可以
        settings.setBuiltInZoomControls(true);
        hot_show_webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url); // 在当前的webview中跳转到新的url

                return true;
            }
        });

    }
}
