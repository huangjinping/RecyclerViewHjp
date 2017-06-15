package com.de.hjp.recyclerview.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * author Created by harrishuang on 2017/6/14.
 * email : huangjinping@hdfex.com
 */

@Module
public class AppModule {

    private Context mContext;


    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    Context providesContext(){
        //提供mContext  对象
        return mContext;
    }


}
