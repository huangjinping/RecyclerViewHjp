package com.de.hjp.recyclerview.jsjava;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.timer.TimedTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView web_js;
    private Button button6;
    private TextView txt_js;
    private MyWebViewClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        Toast.makeText(this, getHostIP(), Toast.LENGTH_SHORT).show();

        System.out.println("=====>task111>>>>>7");

        TimedTask.getTimedTask().requestListener(new TimedTask.TimedTaskListener() {
            @Override
            public void onTimedTask(int recLen) {
                System.out.println("===getTimedTask==>>>>>>9"+recLen);

            }
        });
    }

    private void initView() {
        web_js = (WebView) findViewById(R.id.web_js);
        txt_js = (TextView) findViewById(R.id.txt_js);

        WebSettings webSettings = web_js.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        client = new MyWebViewClient(this, web_js);

        webSettings.setDomStorageEnabled(true);
//        web_js.addJavascriptInterface(new JavaScriptObject(), "nativeObject");
//        web_js.loadUrl("file:///android_asset/test.html");
        web_js.addJavascriptInterface(new JavascriptInterface(this), "openImage");
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

//        try {
//            Log.d("x","=======开始==========");
//            Document document = Jsoup.parse(htmlData);
//            Elements body = document.select("body");
//            for (Element e:body) {
//                Log.d("x","详情连接:"+e.select("img").attr("src"));
//            }
//
//        }catch (Exception e){
//            Log.d("x","=========Exception========"+e.getMessage());
//
//            e.printStackTrace();
//        }
        web_js.loadUrl("http://home.meishichina.com/show-top-type-recipe.html");


        new Thread() {
            @Override
            public void run() {
                super.run();
                open();
            }
        }.start();


        String htmlData1 = "";

//        txt_js.setText(Html.fromHtml(htmlData1, null, new MaxaTagHandler(this)));
//
//        txt_js.setMovementMethod(LinkMovementMethod.getInstance());
//                tv1.setMovementMethod(LinkMovementMethod.getInstance());
//        MaxaTagHandler handler=new MaxaTagHandler(this);
//        txt_js.setText(Html.fromHtml(htmlData1,null,handler));
//        web_js.loadData(htmlData, "text/html; charset=UTF-8", null);
//        web_js.loadUrl("http://10.1.21.76:8080/day16_00_ajax/");
//        web_js.setWebViewClient(new WebViewClient() {
//        });
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

//    public class JavaScriptObject {
//        @JavascriptInterface
//        public void onSuccess(String name) {
//            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
//        }
//
//        @JavascriptInterface
//        public void fun2(String name) {
//            Toast.makeText(getApplicationContext(), "调用fun2:" + name, Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onBackPressed() {

        if (web_js.canGoBack()) {
            web_js.goBack();
        } else {

            super.onBackPressed();
            finish();
        }
    }

    private void open() {
        try {
            //从一个URL加载一个Document对象。
            Document doc = Jsoup.connect("http://home.meishichina.com/show-top-type-recipe.html").get();
//            //选择“美食天下”所在节点
//            Elements elements = doc.select("div.top-bar");
//            //打印 <a>标签里面的title
//            System.out.println(elements.select("a").attr("title"));
//

            Elements elements1 = doc.select("body img");
            for (Element element : elements1) {
                String attr = element.select("img").attr("data-src");
                System.out.println("===========>>>>>>>>>>>>>>>>>>" + attr);
            }

        } catch (Exception e) {
            System.out.println("===========>>>>>>>>>>>>>>>>>>" + e.toString());
        }

    }

    class MyWebViewClient extends WebViewClient {

        private static final String TAG = "MyWebViewClient";

        private Context mContext;
        private WebView mwebView;

        public MyWebViewClient(Context context, WebView webView) {
            this.mContext = context;
            this.mwebView = webView;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            addImageClickListner();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        private void addImageClickListner() {

            System.out.println("===========>addImageClickListner>>>>>>>>>>>>>>>>>" );


            mwebView.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByClassName(\"imgLoad\"); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "    objs[i].onclick=function()  " +
                    "    {  "
                    + "        window.imagelistner.openImage(this.src);  " +
                    "    }  " +
                    "}" +
                    "})()");
        }
    }

    public class JavascriptInterface {

        private Context context;

        public JavascriptInterface(Context context) {
            this.context = context;
        }

        @android.webkit.JavascriptInterface
        public void openImage(String img) {

            Toast.makeText(context, "img" + img, Toast.LENGTH_SHORT).show();
//            System.out.println(img);
//            Intent intent = new Intent();
//            intent.putExtra("image", img);
//            intent.setClass(context, ShowImgActivity.class);
//            context.startActivity(intent);
//            System.out.println(img);
        }
    }


    public static String getHostIP() {

        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("yao", "SocketException");
            e.printStackTrace();
        }
        return hostIp;

    }

}
