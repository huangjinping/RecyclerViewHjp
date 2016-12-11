package com.de.hjp.recyclerview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by harrishuang on 2016/12/7.
 */

public class DrawableLayout extends RelativeLayout  implements View.OnClickListener{


    private int mTop;
    private int childHeight;
    private boolean isClose = true;
    private boolean isScrolling = false;
    private boolean hiden = true;

    public DrawableLayout(Context context) {
        super(context);
        init();
    }




    public DrawableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnClickListener(this);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View child = getChildAt(0);
        int childWidth = child.getMeasuredWidth();
        childHeight = child.getMeasuredHeight();
        if (hiden) {
            child.layout(0, -childHeight, childWidth, 0);
            return;
        }
        child.layout(0, -mTop, childWidth, childHeight - mTop);
    }


    public int getmTop() {
        return mTop;
    }

    public void setmTop(int mTop) {
        this.mTop = mTop;

    }


    public void closeMenu() {

        if (isClose || isScrolling) {
            return;
        }
        isClose = !isClose;
        hiden = false;

        ObjectAnimator anim = ObjectAnimator.ofInt(this, "mTop", 0, childHeight);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTop = (int) animation.getAnimatedValue();
                isScrolling = true;
                requestLayout();
                invalidate();

            }
        });
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isScrolling = false;
                DrawableLayout.this.setBackgroundColor(getResources().getColor(R.color.trancent));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
        anim.start();
    }


    /**
     *
     */
    public void openMenu() {
        if (!isClose || isScrolling) {
            return;
        }


        isClose = !isClose;
        hiden = false;
        ObjectAnimator anim = ObjectAnimator.ofInt(this, "mTop", childHeight, 0);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTop = (int) animation.getAnimatedValue();
                isScrolling = true;

                requestLayout();
                invalidate();
            }

        });
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationStart(Animator animation) {
                DrawableLayout.this.setBackgroundColor(getResources().getColor(R.color.myTrances));

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isScrolling = false;

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
        anim.start();
    }

    @Override
    public void onClick(View v) {
        closeMenu();

    }
}
