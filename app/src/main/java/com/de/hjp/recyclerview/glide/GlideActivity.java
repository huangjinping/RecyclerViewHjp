package com.de.hjp.recyclerview.glide;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.request.FutureTarget;
import com.de.hjp.recyclerview.CornersTransform;
import com.de.hjp.recyclerview.R;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        for (int i = 0; i <100 ; i++) {
            com.tencent.mars.xlog.Log.d("ddddddddddd","dddddddddddddddddddddddddddddd");

        }

    }

    public void onCircle(View view) {
        ImageView v = (ImageView) view;
        Glide.with(this).load(R.mipmap.bg_idcard_hander).transform(new GlideCircleTransform(this)).into(v);

    }

    public void onCorners(View view) {
        ImageView v = (ImageView) view;
        Glide.with(this).load(R.mipmap.bg_idcard_hander).transform(new CornersTransform(this, 30)).into(v);

    }

    public void onLoad(View view) {
        ImageView v = (ImageView) view;
        Glide.with(this).load("https://static.pexels.com/photos/5968/wood-nature-dark-forest-medium.jpg").transform(new CornersTransform(this, 30)).into(v);
    }


    public void onCache(View view) {
        ImageView v = (ImageView) view;

        System.out.println("=====================S");
        new Thread(){
            @Override
            public void run() {
                super.run();
                String imgPath = getImgPath("https://static.pexels.com/photos/5968/wood-nature-dark-forest-medium.jpg", GlideActivity.this);
                Log.d("hjp",imgPath);
            }
        }.start();
    }

    /**
     * 获取缓存大小
     * @param dir 缓存目录
     * @return 缓存的大小
     */
    private static long calculateSize(File dir) {
        if (dir == null) return 0;
        if (!dir.isDirectory()) return dir.length();
        long result = 0;
        File[] children = dir.listFiles();
        if (children != null)
            for (File child : children)
                result += calculateSize(child);
        return result;
    }
//    long totalSize = calculateSize(new File(getCacheDir(), DiskCache.Factory.DEFAULT_DISK_CACHE_DIR));


    /**
     * 获取缓存的地址
     * Create by Raye on 2016年8月5日11:26:15
     * @param url 图片url
     * @param context 上下文
     * @return 图片路径
     */
    public static String getImgPath(String url,Context context){
        FutureTarget<File> future = Glide.with(context)
                .load(url)
                .downloadOnly(500, 500);
        try {
            File cacheFile = future.get();
            return cacheFile.getAbsolutePath();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
