package com.de.hjp.recyclerview.index;

/**
 * Created by harrishuang on 2016/12/11.
 */

public class Item  {

    private String titile;
    private Class aClass;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    @Override
    public String
    toString() {
        return "Item{" +
                "titile='" + titile + '\'' +
                '}';
    }
}
