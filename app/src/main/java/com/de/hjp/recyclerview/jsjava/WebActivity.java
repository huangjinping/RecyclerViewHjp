package com.de.hjp.recyclerview.jsjava;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class WebActivity extends AppCompatActivity  {

    private WebView web_js;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        web_js = (WebView) findViewById(R.id.web_js);

        WebSettings webSettings = web_js.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        web_js.addJavascriptInterface(new JavaScriptObject(), "nativeObject");
        web_js.loadUrl("file:///android_asset/test.html");
        web_js.setWebViewClient(new WebViewClient() {

        });
    }



    public void onMessage(View view) {
        web_js.loadUrl("javascript:funFromjs()");
        Toast.makeText(this, "调用javascript:funFromjs()", Toast.LENGTH_LONG).show();
    }

    public  class  JavaScriptObject{
        @JavascriptInterface
        public void onSuccess(String name) {
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        }
        @JavascriptInterface
        public void fun2(String name) {
            Toast.makeText(getApplicationContext(), "调用fun2:" + name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {

        if (web_js.canGoBack()) {
            web_js.goBack();
        } else {

            super.onBackPressed();
            finish();
        }
    }
}
