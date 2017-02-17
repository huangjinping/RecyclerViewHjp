package com.de.hjp.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by harrishuang on 2016/12/12.
 */

public class GifLoadingImageView extends ImageView {


    public GifLoadingImageView(Context context) {
        super(context);
    }

    public GifLoadingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public GifLoadingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Glide.with(getContext()).load(R.raw.ic_loading).asGif().into(this);

    }
}
