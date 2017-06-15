package com.de.hjp.recyclerview.dagger2;

import android.content.Context;
import android.widget.Toast;

/**
 * author Created by harrishuang on 2017/6/14.
 * email : huangjinping@hdfex.com
 */

//@Module
public class AppModule {

    private Context mContext;


    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

//    @Provides
//    @PerApp
    Context providesContext(){
        //提供mContext  对象

        Toast.makeText(mContext, "AppModule", Toast.LENGTH_SHORT).show();

        return mContext;
    }


}
