package com.bobo.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bobo.mvp.R;
import com.bobo.mvp.bean.Stu;
import com.bobo.mvp.presenter.StuPresenter;
import com.bobo.mvp.service.IntentServiceImpl;
import com.bobo.mvp.service.NomorlService;
import com.bobo.mvp.view.StuView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StuActivity extends BaseActivity<StuPresenter>  implements StuView{

    @BindView(R.id.tv_age)
    public TextView tv_age;

    @Override
    protected void createPresenter() {
        mPresenter = new StuPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.content_stu;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initData() {

    }
    @Override
    public void updateAge( int age) {
        tv_age.setText(age+"");
    }

    @OnClick(R.id.bt_click)
    public void btAddAge(){
        Log.d("aaa","aaa");
        String old_age = tv_age.getText().toString();
        mPresenter.updateAge(Integer.parseInt(old_age),9);
    }

    @OnClick(R.id.bt_click1)
    public void onclickSercice(){
        Intent intent = new Intent(this, NomorlService.class);
        intent.setAction("aaa");
        startService(intent);
    }

    @OnClick(R.id.bt_click2)
    public void onclickIntentSercice(){
        Intent intent = new Intent(this, IntentServiceImpl.class);
        intent.setAction("aaa");
        startService(intent);
    }

    @Override
    public void showError(String msg) {

    }

}
