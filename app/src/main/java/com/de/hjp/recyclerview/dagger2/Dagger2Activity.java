package com.de.hjp.recyclerview.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.mvp.contract.Dagger2Contract;

import javax.inject.Inject;


/**
 * Created by harrishuang on 2017/4/14.
 */
//http://blog.csdn.net/lisdye2/article/details/51942511
public class Dagger2Activity extends AppCompatActivity implements Dagger2Contract.View {


    @Inject   //标明需要注入的对象
            Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        // 构造桥梁对象
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //注入
        component.inject(this);
    }

    /**
     * 提交数据
     *
     * @param view
     */
    public void onToast(View view) {
        person.log();
    }

}
