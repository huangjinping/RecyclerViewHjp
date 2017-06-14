package com.de.hjp.recyclerview.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by harrishuang on 2017/4/24.
 */

@Singleton
@Component(modules = MainModule.class)  // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {

    //定义注入的方法
    void inject(Dagger2Activity activity);

}