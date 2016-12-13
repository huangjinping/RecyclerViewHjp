package com.de.hjp.recyclerview.eventbus;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class MyBus {


    private  static MyBus myBus;
    public  static  synchronized MyBus getInstance(){
            if (myBus==null){
                myBus=new MyBus();
            }

        return myBus;
    }








}
