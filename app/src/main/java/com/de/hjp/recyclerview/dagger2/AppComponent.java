package com.de.hjp.recyclerview.dagger2;

import android.content.Context;

import dagger.Component;

/**
 * author Created by harrishuang on 2017/6/14.
 * email : huangjinping@hdfex.com
 */

//@PerApp
//@Component(modules = AppModule.class)
public interface AppComponent {
    //向其下层提供Context对象
    Context proContext();
    
}
