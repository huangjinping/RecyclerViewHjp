package com.de.hjp.recyclerview.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.de.hjp.recyclerview.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by harrishuang on 2016/12/11.
 */

public class EventBusSecendActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbusssecend);
    }

    public void sendMessage(View view) {
        EventBus.getDefault().post("哈哈");

//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//            }
//        }.start();
    }
}
