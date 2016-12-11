package com.de.hjp.recyclerview.rxjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by harrishuang on 2016/12/8.
 */

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ImageView imageView;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        initView();
        RxView.clicks(button).throttleFirst(10000, TimeUnit.MILLISECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Log.d("hjp", Thread.currentThread().getName());
                button.setText("===hjp====" + button.getId());
            }
        });

        RxTextView.afterTextChangeEvents(editText).subscribe(new Action1<TextViewAfterTextChangeEvent>() {
            @Override
            public void call(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {

            }
        });


    }

    public void onOpen(View view) {
//        initRxjava1();
//        initRxjava2();
//        initRxjava3();
//        initRxjava4();
//        initRxjava5(R.mipmap.ic_launcher, imageView);
//        initRxjava6(R.mipmap.ic_launcher, imageView);
//        initRxjava7(R.mipmap.ic_launcher, imageView);
        initRxjava8(R.mipmap.ic_launcher, imageView);

    }

    private void initRxjava8(final int ic_launcher, final ImageView imageView) {
        Observable.create(new Observable.OnSubscribe<Drawable>() {

            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Log.d("hjp", Thread.currentThread().getName());

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext(getResources().getDrawable(ic_launcher));
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                Log.d("hjp", Thread.currentThread().getName());
                imageView.setVisibility(View.VISIBLE);
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                Log.d("hjp", Thread.currentThread().getName());
                imageView.setImageDrawable(drawable);
            }
        });


    }

    private void initRxjava7(int ic_launcher, final ImageView imageView) {
        Observable.just(ic_launcher).lift(new Observable.Operator<Drawable, Integer>() {
            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super Drawable> subscriber) {


                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("hjp", Thread.currentThread().getName());

                        subscriber.onNext(getResources().getDrawable(integer));
                    }
                };
            }
        }).subscribe(new Action1<Drawable>() {
            @Override
            public void call(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }
        });

    }


    private void initRxjava6(final int ic_launcher, final ImageView imageView) {
        Observable.just(ic_launcher).map(new Func1<Integer, Drawable>() {
            @Override
            public Drawable call(Integer integer) {
                return getResources().getDrawable(ic_launcher);
            }
        }).subscribe(new Action1<Drawable>() {
            @Override
            public void call(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }
        });
    }


    private void initRxjava5(final int ic_launcher, final ImageView imageView) {

        Observable<Drawable> observable = Observable.create(new Observable.OnSubscribe<Drawable>() {

            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(ic_launcher);
                Log.d("hjp", Thread.currentThread().getName());


                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        });
        observable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {
                Log.d("hjp", Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(RxJavaActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }
        });
    }


    private void initRxjava4() {
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("hjp", s);

            }
        };

        Action1<Throwable> action11 = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d("hjp", throwable.getMessage());
            }
        };

        Action0 action0 = new Action0() {
            @Override
            public void call() {
                Log.d("hjp", "action0");

            }
        };
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("小白");

                subscriber.onNext("小牧");
                subscriber.onNext("" + (1 / 0));
                subscriber.onCompleted();
            }
        });
        observable.subscribe(action1, action11, action0);

    }

    private void initRxjava3() {
//        String[] a={"2","3"};
        List<String> m = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            m.add("" + i);
        }
        Observable<String> obserable = Observable.from(m);
        obserable.subscribe(new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                Log.d("hjp", "onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                Log.d("hjp", e.getMessage());

            }

            @Override
            public void onNext(String s) {
                Log.d("hjp", s);
            }
        });
    }


    private void initRxjava1() {

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("小白");
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                subscriber.onNext("小牧");
//                subscriber.onNext("" + (1 / 0));
                subscriber.onCompleted();

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("hjp", "onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                Log.d("hjp", e.getMessage());

            }

            @Override
            public void onNext(String s) {
                Log.d("hjp", s);
            }
        });
    }


    private void initRxjava2() {


        Observable<String> observable = Observable.just("1", "2");
        observable.observeOn(Schedulers.io());
        observable.subscribeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                Log.d("hjp", "onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                Log.d("hjp", e.getMessage());

            }

            @Override
            public void onNext(String s) {
                Log.d("hjp", s);
            }
        });
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {

    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "editTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
