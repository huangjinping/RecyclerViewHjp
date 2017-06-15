package com.de.hjp.recyclerview.dagger2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by harrishuang on 2017/4/24.
 */

public class Person {

    private Context mContext;

    public Person(Context context){
        mContext = context;
        Log.i("dagger","create");
    }

    public Person(String name){
        Log.i("dagger",name);
    }
}
