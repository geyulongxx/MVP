package com.bobo.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bobo.mvp.App;
import com.bobo.mvp.R;
import com.bobo.mvp.bean.Album;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by bobo on 2018/3/10.
 */

public class AlbumAdapter extends RecyclerView.Adapter {
    private List<Album> list;
    public AlbumAdapter(List<Album> list){
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(App.getInstance()).load(list.get(position).getCoverUrl()).into(((ViewHolder)holder).iv_album_cover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_album_cover;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_album_cover = (ImageView) itemView.findViewById(R.id.iv_album_cover);
        }
    }

}
