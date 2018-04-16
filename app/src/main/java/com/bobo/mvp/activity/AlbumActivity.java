package com.bobo.mvp.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bobo.mvp.R;
import com.bobo.mvp.adapter.AlbumAdapter;
import com.bobo.mvp.bean.Album;
import com.bobo.mvp.bean.BaseResult;
import com.bobo.mvp.presenter.AlbumPresenter;
import com.bobo.mvp.view.AlbumView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by bobo on 2018/3/10.
 */

public class AlbumActivity extends BaseActivity<AlbumPresenter> implements AlbumView {
    @BindView(R.id.rv_album_list)
    public RecyclerView rv_album_list;

    private List<Album> list = new ArrayList<>();
    private AlbumAdapter albumAdapter;

    @Override
    public void showError(String msg) {

    }

    @Override
    protected void initViews() {
        albumAdapter = new AlbumAdapter(list);
        rv_album_list.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
//        rv_album_list.setLayoutManager(new GridLayoutManager(this, 3));
//        rv_album_list.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rv_album_list.setAdapter(albumAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.loadAlbums(0);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new AlbumPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.album_layout;
    }

    @Override
    public void loadData(BaseResult<List<Album>> albums) {
        list.addAll(albums.getObject());
        albumAdapter.notifyDataSetChanged();
    }

}
