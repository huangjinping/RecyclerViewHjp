package com.de.hjp.recyclerview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.Utils;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by harrishuang on 2017/1/3.
 */

public class ApliyView extends ImageView {


    private SurFace surFace;
    private int current = 1;
    private boolean endShow = false;
    private Subscription subscribe;

    public boolean isRuning=false;

    public void setEndShow() {
        isRuning=false;
        this.endShow = true;
        if (subscribe!=null){
            subscribe.unsubscribe();
        }

    }

    public ApliyView(Context context) {
        super(context);
        init();
    }

    public ApliyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ApliyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        surFace = new SurFace();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int witdth = getWidth();
        int height = getHeight();
        canvas.drawCircle(witdth / 2, height / 2, witdth / 2 - 10, surFace.circlePaint);
        int radius = witdth / 2 - 10;
        int center = getWidth() / 2;


        if (endShow) {

            Path path = new Path();
            path.moveTo(witdth / 3, height / 2);
            path.lineTo(witdth / 2, height * 2 / 3);
            path.lineTo(witdth * 3 / 4, height / 4);

            canvas.drawPath(path, surFace.arcPaint);
        } else {
            float startAngle01 = -90 - current;
            float sweepAngle01 = 90;
            RectF rect = new RectF(center - radius, center - radius, center
                    + radius, center + radius);
            canvas.drawArc(rect, startAngle01, sweepAngle01, false, surFace.arcPaint);
        }


    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        surFace.init();

    }


    public void start() {
        endShow = false;
        if (isRuning) {
            return;
        }
        isRuning=true;

        subscribe = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                int i = 0;
                while (i < 360) {
                    if (endShow){
                        i=1000;
                    }
                    try {
                        Thread.sleep(2L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i+=2;
                    if (i == 360) {
                        i = 0;
                    }
                    ApliyView.this.postInvalidate();
                    subscriber.onNext(i);
                }

            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {

                current = integer;
//                ApliyView.this.invalidate();
            }
        });


    }


    private class SurFace {
        public int circleColor = getResources().getColor(R.color.yuan_bg);
        public Paint circlePaint;

        public int arcColor = getResources().getColor(R.color.colorPrimary);
        public Paint arcPaint;

        public void init() {
            circlePaint = new Paint();
            circlePaint.setColor(circleColor);
            circlePaint.setAntiAlias(true); //去掉锯齿
            circlePaint.setStrokeWidth(Utils.dp2px(getContext(), 5));
            circlePaint.setStyle(Paint.Style.STROKE);
            arcPaint = new Paint();
            arcPaint.setColor(arcColor);
            arcPaint.setAntiAlias(true); //去掉锯齿
            arcPaint.setStrokeWidth(Utils.dp2px(getContext(), 5));
            arcPaint.setStyle(Paint.Style.STROKE);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (subscribe!=null){
            subscribe.unsubscribe();
        }
    }
}
