package com.de.hjp.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by harrishuang on 16/4/17.
 */
public class GalleryActivity extends AppCompatActivity {

    private XRecyclerView rec_gallery;
    private String[] urls;
    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        initView();
        urls = ImageUrlUtils.getImageUrls();
        adapter=new MyAdapter();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager gridLayoutManaget=new GridLayoutManager(this,6);
//        rec_gallery.setLayoutManager(gridLayoutManaget);
        rec_gallery.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        rec_gallery.setHasFixedSize(true);
        rec_gallery.setAdapter(adapter);
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        rec_gallery.addItemDecoration(decoration);

        rec_gallery.setLaodingMoreProgressStyle(ProgressStyle.SquareSpin);
        rec_gallery.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initView() {
        rec_gallery = (XRecyclerView) findViewById(R.id.rec_gallery);
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String url = urls[position];
            url=url.replace("http://","https://");

            Glide.with(GalleryActivity.this).load(url).into(holder.img_item);
//            holder.txt_name.setText(url);
        }

        public MyAdapter() {
            super();
        }


        @Override
        public int getItemCount() {
            return urls.length;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(GalleryActivity.this).inflate(R.layout.item_gallery, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }


        class ViewHolder extends RecyclerView.ViewHolder {
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


    class  SpacesItemDecoration extends  RecyclerView.ItemDecoration{
         private  int  space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }

        }
    }
}
