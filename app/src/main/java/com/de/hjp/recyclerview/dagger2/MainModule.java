package com.de.hjp.recyclerview.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by harrishuang on 2017/4/24.
 */
@Module   //提供依赖对象的实例
public class MainModule {
    // 关键字，标明该方法提供依赖对象
//    @Singleton
//    @Provides
//    Person providerPerson() {
//        //提供Person对象
//        return new Person("ddd");
//    }

    private Context mContext;

    public MainModule(Context mContext) {
        this.mContext = mContext;
    }

    //
    @Provides
    Context provicdesContext() {
        return mContext;
    }

    //    @Singleton
    @Provides
    Person providerPerson(Context context) {
        return new Person(context);
    }
//


}