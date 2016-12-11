package com.de.hjp.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * Created by harrishuang on 2016/12/6.
 */

public class WoDecodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LinearLayout(this));
        myStart();
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            System.out.print("println"+msg.what);
        }
    };



    /**
     * 开始线程
     */
    private void myStart(){
        new Thread(){
            @Override
            public void run() {
                /**
                 * 开始跑数据
                 */
                handler.sendEmptyMessageDelayed(1,1*1000);

            }
        }.start();
    }
}
