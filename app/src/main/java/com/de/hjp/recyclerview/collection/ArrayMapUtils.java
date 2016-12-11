package com.de.hjp.recyclerview.collection;

import android.support.v4.util.ArrayMap;

/**
 * Created by harrishuang on 2016/12/10.
 */

public class ArrayMapUtils {

    private static ArrayMap<String, String> arrayMap;
    public   static ArrayMap getInstance(){
        if (arrayMap==null){
            arrayMap=new ArrayMap<>();

        }
        return arrayMap;
    }
}
