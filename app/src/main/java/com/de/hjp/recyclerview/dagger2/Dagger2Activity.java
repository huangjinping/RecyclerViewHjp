package com.de.hjp.recyclerview.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.mvp.contract.Dagger2Contract;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by harrishuang on 2017/4/14.
 */
//http://blog.csdn.net/lisdye2/article/details/51942511
//http://www.jianshu.com/p/39d1df6c877d
public class Dagger2Activity extends AppCompatActivity implements Dagger2Contract.View {


    @Named("context") // 标记
    @Inject
    Person person;

    @Named("name")  // 标记
    @Inject
    Person person2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
//        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
//        //注入当前
//        build.inject(this);
        component.inject(this);

        AppComponent appCom = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ActivityComponent build = DaggerActivityComponent.builder().appComponent(appCom).activityMoudule(new ActivityMoudule()).build();
        build.inject(this);

    }

    /**
     * 提交数据
     *
     * @param view
     */
    public void onToast(View view) {
//        person.log();
        Toast.makeText(this, ">>>>>>v", Toast.LENGTH_SHORT).show();
    }

}
