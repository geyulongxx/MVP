package com.bobo.mvp.net;

import com.bobo.mvp.bean.Album;
import com.bobo.mvp.bean.BaseResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bobo on 2018/3/10.
 */

public interface Api {
    @FormUrlEncoded
    @POST("/album/list")
    Observable<BaseResult<List<Album>>> getAlbumList(@Field("page")int page);
}
