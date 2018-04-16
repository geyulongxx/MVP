package com.bobo.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bobo.mvp.App;
import com.bobo.mvp.presenter.BasePresenter;
import com.bobo.mvp.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by bobo on 2018/3/10.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity implements BaseView {
    private Unbinder bind;
    public T mPresenter;
    public Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        createPresenter();
        this.context=this;
        App.getInstance().addActivity(this);
        initViews();
        initData();
    }

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract void createPresenter();

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null)
            bind.unbind();
        if(mPresenter!=null)
            mPresenter.detachView();
        App.getInstance().removeActivity(this);
    }
}
