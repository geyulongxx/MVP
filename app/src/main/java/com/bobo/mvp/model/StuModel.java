package com.bobo.mvp.model;

import com.bobo.mvp.bean.Stu;

/**
 * Created by bobo on 2018/3/10.
 */

public class StuModel {

    public void addAge(int old, int age, OnLoginListener onLoginListener){
        onLoginListener.scuess(old+age);
    }
}
