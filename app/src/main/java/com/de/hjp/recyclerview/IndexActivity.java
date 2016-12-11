package com.de.hjp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by harrishuang on 16/4/17.
 */
public class IndexActivity extends AppCompatActivity {


    private DrawableLayout myview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();

        myStart();

    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {


        }
    };


    private void myStart() {
        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }


    public void onLinerlayout(View view) {
//        myview.openMenu();
        startActivity(new Intent(this, SecendActivity.class));
    }

    public void onGallery(View view) {
//        myview.closeMenu();

        startActivity(new Intent(this, GalleryActivity.class));

    }

    private void initView() {
        myview = (DrawableLayout) findViewById(R.id.myview);


    }
}
