package com.bobo.mvp.view;

import com.bobo.mvp.bean.Album;
import com.bobo.mvp.bean.BaseResult;

import java.util.List;

/**
 * Created by bobo on 2018/3/10.
 */

public interface AlbumView extends BaseView {

    void loadData(BaseResult<List<Album>> albums);
}
