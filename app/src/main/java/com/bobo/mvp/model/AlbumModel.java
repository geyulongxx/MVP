package com.bobo.mvp.model;

import com.bobo.mvp.bean.Album;
import com.bobo.mvp.bean.BaseResult;
import com.bobo.mvp.net.Api;
import com.bobo.mvp.util.RetrofitUitls;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bobo on 2018/3/10.
 */

public class AlbumModel {
    public void getList(int page, Observer<BaseResult<List<Album>>> observer){
        RetrofitUitls.get(Api.class).getAlbumList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
