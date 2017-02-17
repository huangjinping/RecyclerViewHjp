package com.de.hjp.recyclerview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.de.hjp.recyclerview.R;

/**
 * Created by harrishuang on 2017/1/3.
 */

public class CostomViewActivity extends AppCompatActivity {

    private ApliyView apliy_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costomview);
        initView();

    }

    private void initView() {
        apliy_view = (ApliyView) findViewById(R.id.apliy_view);
    }

    public void onEnd(View view) {
        apliy_view.setEndShow();

    }

    public void onstart(View view) {
        apliy_view.start();

    }
}
