package com.de.hjp.recyclerview.retrofit;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * author Created by harrishuang on 2017/5/10.
 * email : huangjinping@hdfex.com
 */

public interface ApiStores {


    @FormUrlEncoded
    @POST("ddddd")
    Observable<String> login(@Field("name") String name, @Field("passsword") String password);

}
