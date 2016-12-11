package com.de.hjp.recyclerview.collection;

import android.util.SparseArray;

/**
 * Created by harrishuang on 2016/12/10.
 */

public class SparseArrayUtils  {


    private  static SparseArray<String> sparseArray;

    public static SparseArray  getInstance(){
        if (sparseArray==null){
            sparseArray=new SparseArray<>();
        }
        return  sparseArray;
    }

}
