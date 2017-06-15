package com.de.hjp.recyclerview.app;

import android.app.Application;

/**
 * author Created by harrishuang on 2017/6/15.
 * email : huangjinping@hdfex.com
 */

public class App extends Application {
//    为什么可以使用静态
//    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // 实例化
//        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
