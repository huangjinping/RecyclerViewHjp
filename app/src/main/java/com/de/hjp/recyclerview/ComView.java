package com.de.hjp.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by harrishuang on 2016/12/7.
 */

public class ComView extends View {

    public ComView(Context context) {
        super(context);
    }

    public ComView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ComView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWith(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    /**
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWith(int widthMeasureSpec){
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        int result = 200;
        if (specMode == MeasureSpec.AT_MOST) {//相当于我们设置为wrap_content
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {//相当于我们设置为match_parent或者为一个具体的值
            result = specSize;
        }
        return result;
    }

    /**
     *
     * @param measureSpec
     * @return
     */
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 200;
        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

}
