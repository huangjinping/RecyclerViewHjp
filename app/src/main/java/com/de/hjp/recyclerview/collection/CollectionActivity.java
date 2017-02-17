package com.de.hjp.recyclerview.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.bumptech.glide.Glide;
import com.de.hjp.recyclerview.CornersTransform;
import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.glide.GlideCircleTransform;


//Glid 高级使用
//http://www.tuicool.com/articles/eUBjmai

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

        Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), arrayMap.get("" + 6) + "", Snackbar.LENGTH_LONG).setAction("小白", new View.OnClickListener() {
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
        });
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
        snackbar.show();
    }

    public void onSetImage(View view) {

        try {

            TSnackbar.make(findViewById(R.id.layout_content_view),"Hello from TSnackBar.", TSnackbar.LENGTH_LONG).show();
//            Glide.with(this).load(R.raw.ic_loading).asGif().into((ImageView) view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
