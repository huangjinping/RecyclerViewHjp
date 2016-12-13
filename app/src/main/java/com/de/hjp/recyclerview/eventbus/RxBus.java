package com.de.hjp.recyclerview.eventbus;

import android.support.annotation.NonNull;

import java.util.Vector;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 *
 *
 *
 * 这个是无法解绑的;注册的时候Object根本没有去掉
 * Created by harrishuang on 2016/12/12.
 */

public class RxBus {
    private static RxBus instance;
    private Vector<Subject> subjectList = new Vector<>();

    private RxBus() {
    }

    public static synchronized RxBus getInstance() {
        if (null == instance) {
            instance = new RxBus();
        }
        return instance;
    }
    // PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者

    public synchronized <T> Observable<T> register(@NonNull Object object) {
        Subject<T, T> subject = (Subject<T, T>) new SerializedSubject<>(PublishSubject.create());
        Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());
        subjectList.add(subject);
        return subject;
    }

    public synchronized void unregister(Object object) {
        subjectList.remove(object);
    }

    public void post(@NonNull Object content) {
        synchronized (this) {
            for (Subject subject : subjectList) {
                if (subject != null) {
                    subject.onNext(content);
                }
            }
        }
    }



//    1、Subject同时充当了Observer和Observable的角色，Subject是非线程安全的，要避免该问题，需要将 Subject转换为一个 SerializedSubject ，上述RxBus类中把线程非安全的PublishSubject包装成线程安全的Subject。
//
//            2、PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者。
//
//            3、ofType操作符只发射指定类型的数据，其内部就是filter+cast

}
