package com.bobo.mvp.presenter;

import com.bobo.mvp.model.OnLoginListener;
import com.bobo.mvp.model.StuModel;
import com.bobo.mvp.view.BaseView;
import com.bobo.mvp.view.StuView;

/**
 * Created by bobo on 2018/3/10.
 */

public class StuPresenter implements BasePresenter{
    private StuView stuView;
    private StuModel stuModel;
    public StuPresenter(StuView stuView){
        this.stuView=stuView;
        this.stuModel = new StuModel();
    }

    public void updateAge(int oldAge,int age){
        stuModel.addAge(oldAge, age, new OnLoginListener() {
            @Override
            public void scuess(int newAge) {
                stuView.updateAge(newAge);
            }
        });
    }

    @Override
    public void detachView() {
        stuView=null;
    }
}
