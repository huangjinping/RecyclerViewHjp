package com.de.hjp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by harrishuang on 2016/12/12.
 */

public class GalleryViewHolderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public  class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView txt_name;
        public ImageView img_item;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.txt_name = (TextView) rootView.findViewById(R.id.txt_name);
            this.img_item = (ImageView) rootView.findViewById(R.id.img_item);
        }

    }
}
