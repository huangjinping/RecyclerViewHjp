package com.de.hjp.recyclerview.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

import com.bumptech.glide.gifdecoder.GifDecoder;

import java.io.IOException;

/**
 * Created by harrishuang on 2016/12/12.
 */

public class EmoticonDrawalbe extends AnimationDrawable {
    private Bitmap bitmap;
    private GifDecoder decode;
    private int gifCount;

    public EmoticonDrawalbe(Context context, String source) {
        decode = new GifDecoder(new GifDecoder.BitmapProvider() {
            @Override
            public Bitmap obtain(int width, int height, Bitmap.Config config) {


                return null;
            }

            @Override
            public void release(Bitmap bitmap) {

            }
        });
        gifCount = decode.getFrameCount();

        try {
            decode.read(context.getAssets().open(source), gifCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gifCount <= 0) {
            return;
        }
        for (int i = 0; i < gifCount; i++) {
            bitmap= decode.getNextFrame();
            addFrame(new BitmapDrawable(bitmap), decode.getDelay(i));
        }
        setOneShot(false);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        start();
    }

}
