package com.bobo.mvp.bean;

/**
 * Created by bobo on 2018/3/10.
 */

public class BaseResult<T> {
    private int responseCode;
    private String message;
    private T object;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return responseCode == 1000;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "responseCode=" + responseCode +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
