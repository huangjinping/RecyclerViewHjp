package com.de.hjp.recyclerview.retrofit;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 *回调信息
 * Created by harrishuang on 2016/12/8.
 */

public abstract class ApiCallBack<M> extends Subscriber<M> {



    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()


            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试1";
            }
            onFailure(msg);
        } else {
            if (e.getMessage().contains("Exception")){
                onFailure("服务器异常，请稍后再试");
            }else {
                if (e==null){
                    onFailure(e.getMessage());

                }else {
                    onFailure("服务器异常，请稍后再试");
                }
            }
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);

    }

    @Override
    public void onCompleted() {
        onFinish();
    }


}
