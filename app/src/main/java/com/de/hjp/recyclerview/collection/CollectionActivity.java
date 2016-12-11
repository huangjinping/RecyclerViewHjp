package com.de.hjp.recyclerview.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;

/**
 * Created by harrishuang on 2016/12/10.
 */

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
    }

    public void onParseArray(View view) {
        SparseArray array = SparseArrayUtils.getInstance();
        for (int i = 0; i < 10; i++) {
            array.put(i,"===="+i);
        }
        System.out.println(array.get(3));

    }

    /**
     * 处理数据
     * @param view
     */
    public void onArrayMap(View view) {
        ArrayMap arrayMap = ArrayMapUtils.getInstance();
        for (int i = 0; i < 100; i++) {
            arrayMap.put(""+i,"==="+i);
        }
        System.out.println(arrayMap.get(""+6));

        Snackbar.make(view,arrayMap.get(""+6)+"",Snackbar.LENGTH_LONG).setAction("小白", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CollectionActivity.this, "小白", Toast.LENGTH_SHORT).show();
            }
        }).setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);


            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
            }
        }).show();
    }
}
