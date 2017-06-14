package com.de.hjp.recyclerview.retrofit;

import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.bean.Course;
import com.de.hjp.recyclerview.bean.Student;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * http://gank.io/post/560e15be2dca930e00da1083#toc_20
 * Created by harrishuang on 2017/5/9.
 */

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

    }


    /**
     * map 是有返回的变换的
     *
     * @param view
     */
    public void onRxjavaStart(View view) {

    }

    /**
     *
     */
    private void  retrofit(){
        Observable<String> xiaobai = AppClient.retrofit().create(ApiStores.class).login("xiaobai", "123456");
    }

    /**
     * 对Observable进行整体的变换
     */
    private void  commpose(){
        final String[] arrs = {"1", "3", "4", "5"};


    }


    class LiftAllTransformer implements  Observable.Transformer<Integer,String>{

        @Override
        public Observable<String> call(Observable<Integer> integerObservable) {
            return integerObservable.lift(new Observable.Operator<String, Integer>() {
                @Override
                public Subscriber<? super Integer> call(Subscriber<? super String> subscriber) {
                    return new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Integer integer) {

                        }
                    };
                }
            });

        }
    }

    private void newScheduler() {
        final String[] arrs = {"1", "3", "4", "5"};
        Log.d("zajiaxiaozi", "===map==>>>>>>" + Thread.currentThread().getName());

        Observable.from(arrs).subscribeOn(Schedulers.io()).map(new Func1<String, Integer>() {

            @Override
            public Integer call(String s) {

                Log.d("zajiaxiaozi", "===map==>>>>>>" + Thread.currentThread().getName());
                return Integer.parseInt(s);
            }
        }).observeOn(Schedulers.newThread()).lift(new Observable.Operator<String, Integer>() {


            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("zajiaxiaozi", "=====>lift>>>>>" + Thread.currentThread().getName());

                        subscriber.onNext(integer + "" + integer);
                    }
                };
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("zajiaxiaozi", s + "=======>>>>>>>>zajiaxiaozi" + Thread.currentThread().getName());
            }
        });
    }


    /**
     * LIFT变换
     */
    private void lift() {
        final String[] arrs = {"1", "3", "4", "5"};
        Observable.from(arrs).lift(new Observable.Operator<Integer, String>() {
            @Override
            public Subscriber<? super String> call(final Subscriber<? super Integer> subscriber) {


                return new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        subscriber.onNext(Integer.parseInt(s));
                    }
                };
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d("zajiaxiaozi", "=====" + integer + "");
            }
        });
    }


    /**
     * 一对多变化信息
     */
    private void flatMap() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("学生：" + i);
            List<Course> courseList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Course course = new Course();
                course.setName(i + "学科" + j);
                course.setId(i);
                courseList.add(course);
                student.setCourse(courseList);
            }

            studentList.add(student);
        }

        Observable.from(studentList).flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                return Observable.from(student.getCourse());
            }
        }).subscribe(new Subscriber<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.d("zajiaxiaozi", "dddd" + course.getName());
            }
        });
    }

    /**
     * 过滤加上变换加上操作
     */
    private void filterMap() {

        final String[] arrs = {"1", "3", "4", "5"};
        Observable.from(arrs).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.equals("3") || s.equals("1");
            }
        }).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d("zajiaxiaozi", "==" + integer);
            }
        });
    }
}
