package com.de.hjp.recyclerview.index;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.de.hjp.recyclerview.R;

import java.util.List;

/**
 * Created by harrishuang on 2016/12/11.
 */

public class IndexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Class[] dataList;

    public IndexAdapter(Class[] dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        final Class item = dataList[position];
        viewHolder.item_title.setText(item.getSimpleName());
        viewHolder.item_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            v.getContext().startActivity(new Intent(v.getContext(),item));
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }


    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView item_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_title = (TextView) rootView.findViewById(R.id.item_title);
        }

    }
}
