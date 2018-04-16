package com.bobo.mvp.presenter;

import com.bobo.mvp.bean.Album;
import com.bobo.mvp.bean.BaseResult;
import com.bobo.mvp.model.AlbumModel;
import com.bobo.mvp.view.AlbumView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by bobo on 2018/3/10.
 */

public class AlbumPresenter implements BasePresenter {
    private AlbumView albumView;
    private AlbumModel albumModel;

    public AlbumPresenter(AlbumView albumView) {
        this.albumView = albumView;
        albumModel= new AlbumModel();
    }

    public void loadAlbums(int page) {
        albumModel.getList(page, new Observer<BaseResult<List<Album>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResult<List<Album>> listBaseResult) {
                albumView.loadData(listBaseResult);
            }

            @Override
            public void onError(Throwable e) {
                albumView.showError("加载失败");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void detachView() {
        albumView = null;
    }
}
