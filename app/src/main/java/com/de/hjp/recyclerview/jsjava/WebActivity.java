package com.de.hjp.recyclerview.jsjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.news.GameTagHandler;
import com.de.hjp.recyclerview.news.MaxaTagHandler;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView web_js;
    private Button button6;
    private TextView txt_js;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        web_js = (WebView) findViewById(R.id.web_js);
        txt_js = (TextView) findViewById(R.id.txt_js);

        WebSettings webSettings = web_js.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        web_js.addJavascriptInterface(new JavaScriptObject(), "nativeObject");
//        web_js.loadUrl("file:///android_asset/test.html");

        String htmlData = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Insert title here</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<p style=\"line-height: 26px; text-indent: nullem; text-align: left;\">\n" +
                "\t\t<font color=\"rgb(0, 0, 0)\"><font\n" +
                "\t\t\tface=\"宋体, simsun, sans-serif, Arial\">“明者因时而变，知者随事而制。”当今世界经济陷入困境，根本问题是增长动力不足。解决之道何在？习近平在世界经济论坛2017年年会上指出：“我们必须在创新中寻找出路。只有敢于创新、勇于变革，才能突破世界经济增长和发展的瓶颈。”</font></font>\n" +
                "\t</p>\n" +
                "\t<p style=\"line-height: 26px; text-indent: nullem; text-align: left;\">\n" +
                "\t\t<font color=\"rgb(0, 0, 0)\"><font\n" +
                "\t\t\tface=\"宋体, simsun, sans-serif, Arial\"><b>请随“学习中国”小编一起学习。</b></font></font>\n" +
                "\t</p>\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<font color=\"rgb(51, 51, 51)\"><font\n" +
                "\t\t\tface=\"宋体, simsun, sans-serif, Arial\">\n" +
                "\t\t\t<img width=\"550\"\n" +
                "\t\t\t\t_height=\"380\"\n" +
                "\t\t\t\tsrc=\"http://photocdn.sohu.com/20170205/Img479955101.jpeg\" border=\"0\"\n" +
                "\t\t\t\talt=\"\" /><font color=\"white\"><font face=\"宋体\"><font\n" +
                "\t\t\t\t\t\tstyle=\"font-size: 11px\">2</font></font></font>\n" +
                "\t\t\t</p>\n" +
                "</body>\n" +
                "</html>";



        String htmlData1="嵌入的图片是<Data><![CDATA[<img src=\\\"%1$d\\\"/>和测试自定义的tag是<hello></hello>]]></Data>";




        txt_js.setText(Html.fromHtml(htmlData1,null,new MaxaTagHandler(this)));

        txt_js.setMovementMethod(LinkMovementMethod.getInstance());

//                tv1.setMovementMethod(LinkMovementMethod.getInstance());

//        MaxaTagHandler handler=new MaxaTagHandler(this);

//        txt_js.setText(Html.fromHtml(htmlData1,null,handler));
//        web_js.loadData(htmlData, "text/html; charset=UTF-8", null);

//        web_js.loadUrl("http://10.1.21.76:8080/day16_00_ajax/");

        web_js.setWebViewClient(new WebViewClient() {

        });
        button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(this);
        txt_js.setOnClickListener(this);
    }


    public void onMessage(View view) {
        web_js.loadUrl("javascript:funFromjs()");
        Toast.makeText(this, "调用javascript:funFromjs()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button6:

                break;
        }
    }

    public class JavaScriptObject {
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
