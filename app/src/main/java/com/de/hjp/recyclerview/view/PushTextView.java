package com.de.hjp.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.math.BigDecimal;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by harrishuang on 2016/12/14.
 */

public class PushTextView extends TextView {
    private Subscription subscription;

    public PushTextView(Context context) {
        super(context);
    }

    public PushTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PushTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setPushText(final int number, final int millsecend) {
        PushTextView.this.setText(number + "");

        subscription = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                for (int i = 0; i < 100; i++) {
                    try {

                        Thread.sleep(millsecend / 100);
                        int i1 = number / 100;
                        subscriber.onNext("" + i1 * i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();


            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                PushTextView.this.setText(number + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                PushTextView.this.setText(s);
            }
        });

    }

    public void setPushText(final BigDecimal number, final int millsecend) {
        if (number == null) {
            return;
        }
        PushTextView.this.setText(number.toString() + "");
        final int intValue = number.intValue();
        subscription = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(millsecend / 100);
                        int i1 = intValue / 100;
                        subscriber.onNext("" + i1 * i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();


            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                PushTextView.this.setText(number.toString() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                PushTextView.this.setText(s);
            }
        });

    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

    }
}
