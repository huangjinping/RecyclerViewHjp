package com.de.hjp.recyclerview.listview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.de.hjp.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author Created by harrishuang on 2017/5/23.
 * email : huangjinping@hdfex.com
 */

public class ListActivity extends AppCompatActivity {

    private ListView list_view;
    private List<String> dataList;
    private TempAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_list);
        initView();
        dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("public class ListActivity extends AppCompatActivity {\npublic class ListActivity extends AppCompatActivity {\npublic class ListActivity extends AppCompatActivity {\n");
        }
        adapter = new TempAdapter();
        list_view.setAdapter(adapter);
    }

    private void initView() {
        list_view = (ListView) findViewById(R.id.list_view);
    }


    private class TempAdapter extends BaseAdapter {
        ViewHolder viewHolder;

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(ListActivity.this).inflate(R.layout.item_view, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.txt_name.setText(dataList.get(position));
            return convertView;
        }

        public class ViewHolder {
            public View rootView;
            public TextView txt_name;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.txt_name = (TextView) rootView.findViewById(R.id.txt_name);
            }

        }
    }

}
