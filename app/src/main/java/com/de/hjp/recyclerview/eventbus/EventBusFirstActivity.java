package com.de.hjp.recyclerview.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by harrishuang on 2016/12/11.
 */

public class EventBusFirstActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button3;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventfirst);
        initView();
        EventBus.getDefault().register(this);
    }

    public void onNext(View view) {
        startActivity(new Intent(this, EventBusSecendActivity.class));
    }

    private void initView() {
        button3 = (Button) findViewById(R.id.button3);
        textView2 = (TextView) findViewById(R.id.textView2);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 10)
    public void onEventMainThread(String param) {
        System.out.println(Thread.currentThread().getName());
        Toast.makeText(this, "" + param, Toast.LENGTH_SHORT).show();
        textView2.setText(param);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100)
    public void onEventPostThread(String param) {
        System.out.println("onEventPostThread" + Thread.currentThread().getName());
        EventBus.getDefault().cancelEventDelivery(this);

    }

    @Subscribe
    public void onEventBackgroundThread(String param) {

    }


    @Subscribe
    public void onEventAsync(String param) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
