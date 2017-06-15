package com.de.hjp.recyclerview.dagger2;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by harrishuang on 2017/4/24.
 */

@Module
public class ActivityMoudule {

//    @Provides
//    Person providePerson(Context context){
//        return  new Person(context);
//    }
//


    @Named("Context")  // 通过context创建Person 对象
    @Provides
    Person providePersonContext(Context context){
        //　此方法需要Context 对象
        return new Person(context);
    }


    @Named("name")  // 通过name创建Person 对象
    @Provides
    Person providePersonName(){
        //　此方法需要name
        return new Person("1234");
    }

}
