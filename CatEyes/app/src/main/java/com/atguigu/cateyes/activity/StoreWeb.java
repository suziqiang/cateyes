package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyes.R;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
public class StoreWeb extends Activity implements View.OnClickListener {
    private ImageView imageview_webview_store;
    private TextView textview_textview_store;
    private WebView webview_store;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_webview);
        Log.e("s", "sssssssssssssssssssssssss");
        /*初始化webview*/
        webview_store = (WebView) findViewById(R.id.webview_store);
         /*初始返回键*/
        imageview_webview_store = (ImageView) findViewById(R.id.imageview_webview_store);
        textview_textview_store = (TextView) findViewById(R.id.textview_textview_store);
        /*设置返回键的监听*/
        imageview_webview_store.setOnClickListener(this);
        /*设置webView*/
        setWebView();
        goneWeb();

    }

    private void goneWeb() {
        intent = getIntent();
        String url = intent.getStringExtra("address");
        String name = intent.getStringExtra("name");
        webview_store.loadUrl(url);
        textview_textview_store.setText(name);


    }

    private void setWebView() {
        WebSettings settings = webview_store.getSettings();
        //设置WebView支持javaScript
        settings.setJavaScriptEnabled(true);
        //用户双击页面页面变大变小-页面要支持才可以
        settings.setUseWideViewPort(true);
        //增加缩放按钮 --页面要支持才可以
        settings.setBuiltInZoomControls(true);
        webview_store.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url); // 在当前的webview中跳转到新的url

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}