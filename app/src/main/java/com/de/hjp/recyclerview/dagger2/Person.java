package com.de.hjp.recyclerview.dagger2;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by harrishuang on 2017/4/24.
 */

public class Person {

    Context mContext;

//    public Person(Context mContext) {
//        this.mContext = mContext;
//
//        Toast.makeText(mContext, "PERSON", Toast.LENGTH_SHORT).show();
//    }


//
//    将Module中的providePerson()方法注释，在Person中添加@Inject注解，依然能够实现。
//
//    逻辑如下：
//            - 先判断Module中是否有提供该对象实例化的方法。
//            - 如果有则返回。结束。
//            - 如果没有，则查找该类的构造方法，是否有带有@Inject的方法。如过存在，则返回。
//

    @Inject
    public Person() {
        Log.i("dagger", "person   PersonPersonPersonPersonPersoncreate!!!");
    }

    public void  log(){

           Log.i("dagger", "person create!!!");

    }

}
