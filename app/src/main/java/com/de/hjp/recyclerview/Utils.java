package com.de.hjp.recyclerview;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by harrishuang on 2017/1/3.
 */

public class Utils {
    public static boolean isEmpty(String src) {
        return src == null || src.trim().length() == 0;
    }

    public static int dp2px(Context context, int dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }
}
