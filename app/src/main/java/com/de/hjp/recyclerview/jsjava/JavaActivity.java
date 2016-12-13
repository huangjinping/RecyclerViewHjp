package com.de.hjp.recyclerview.jsjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.de.hjp.recyclerview.R;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
    }


    public void onGoWeb(View view) {
        startActivity(new Intent(this,WebActivity.class));
    }
}
