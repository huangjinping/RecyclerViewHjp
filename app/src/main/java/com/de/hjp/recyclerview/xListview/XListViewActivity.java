package com.de.hjp.recyclerview.xListview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.de.hjp.recyclerview.R;
import com.de.hjp.recyclerview.xListview.xlistView.XListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by harrishuang on 2016/12/13.
 */

public class XListViewActivity extends AppCompatActivity {

    private XListView list_xlist;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlistview);
        initView();
        initData();

    }

    private void initData() {
        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        list_xlist.setAdapter(adapter);
        for (int i = 0; i < 10; i++) {
            dataList.add(i + "".hashCode() + "");
        }
        adapter.notifyDataSetChanged();
        list_xlist.setPullRefreshEnable(true);
        list_xlist.setPullRefreshEnable(true);
        System.out.println("ddddddddddddddddddddd");
        list_xlist.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                startRefresh();
            }


            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initView() {
        list_xlist = (XListView) findViewById(R.id.list_xlist);
    }

    private void startRefresh() {
        Log.d("hjp", "========");

        Observable.create(new Observable.OnSubscribe<Object>() {

            @Override
            public void call(Subscriber<? super Object> subscriber) {
                try {
                    Log.d("hjp", "========");

                    Thread.sleep(2 * 1000);
                    subscriber.onNext("ddd");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Object>() {

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

                Log.d("hjp", o.toString());
                list_xlist.stopRefresh();
                list_xlist.stopLoadMore();
            }
        });
    }
}
