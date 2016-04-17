package com.de.hjp.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by harrishuang on 16/4/17.
 */
public class IndexActivity  extends AppCompatActivity {




   String  a;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


    }

    public  void  onLinerlayout(View view){
    startActivity(new Intent(this,SecendActivity.class));
    }

    public  void onGallery(View view){
        startActivity(new Intent(this,GalleryActivity.class));

    }
}
