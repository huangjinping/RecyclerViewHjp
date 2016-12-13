package com.de.hjp.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by harrishuang on 2016/12/12.
 */

public class GifImage extends ImageView {


    public GifImage(Context context) {
        super(context);
        Log.d("hjp","GifImage");

    }

    public GifImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("hjp","GifImage");

    }

    public GifImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("hjp","GifImage");

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("hjp","onFinishInflate");
        Glide.with(getContext()).load(R.raw.ic_loading).asGif().into(this);

    }
}
