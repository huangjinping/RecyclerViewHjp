package com.de.hjp.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harrishuang on 16/4/9.
 */
public class SecendActivity extends AppCompatActivity {


    private RecyclerView rec_list;
    private List<String> list;
    private SwipeRefreshLayout layout_swi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        initView();
        initData();
        layout_swi.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        layout_swi.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        rec_list.setItemAnimator(new DefaultItemAnimator());

    }

    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        HomeAdapter adapter = new HomeAdapter();
        rec_list.setLayoutManager(new LinearLayoutManager(this));
        rec_list.setAdapter(adapter);

    }

    private void initView() {
        rec_list = (RecyclerView) findViewById(R.id.rec_list);
        layout_swi = (SwipeRefreshLayout) findViewById(R.id.layout_swi);
        rec_list.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }


    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyHolder holder = new MyHolder(LayoutInflater.from(SecendActivity.this).inflate(R.layout.item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.name.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private TextView name;

            public MyHolder(View view) {
                super(view);
                name = (TextView) view.findViewById(R.id.textView);
            }
        }
    }


}
