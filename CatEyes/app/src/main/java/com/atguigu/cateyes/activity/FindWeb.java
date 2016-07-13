package com.atguigu.cateyes.activity;

import android.app.Activity;
import android.os.Bundle;
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
public class FindWeb extends Activity implements View.OnClickListener {
    private WebView webview_find;
    private ImageView imageview_webview_find;
    private TextView textview_textview_find;
    private ImageView imageview_webview_find_fenxiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_webview);
        webview_find = (WebView) findViewById(R.id.webview_find);
        imageview_webview_find = (ImageView) findViewById(R.id.imageview_webview_find);
        imageview_webview_find_fenxiang = (ImageView) findViewById(R.id.imageview_webview_find_fenxiang);
        textview_textview_find = (TextView) findViewById(R.id.textview_textview_find);

         /*得到titlebar的标题*/
        String biaoti = getIntent().getStringExtra("biaoti");
        String url = getIntent().getStringExtra("url");
        webview_find.loadUrl(url);
        /*设置地址*/
        WebSettings settings = webview_find.getSettings();
        /*设置分享图片可见*/
        if(biaoti!=null&&biaoti.equals("票房"))
            imageview_webview_find_fenxiang.setVisibility(View.VISIBLE);



        //设置WebView支持javaScript
        settings.setJavaScriptEnabled(true);
        //用户双击页面页面变大变小-页面要支持才可以
        settings.setUseWideViewPort(true);
        //增加缩放按钮 --页面要支持才可以
        settings.setBuiltInZoomControls(true);
        /*设置标题*/
        textview_textview_find.setText(biaoti);
        /*结束当前页*/
        imageview_webview_find.setOnClickListener(this);
        webview_find.setWebViewClient(new WebViewClient() {
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
