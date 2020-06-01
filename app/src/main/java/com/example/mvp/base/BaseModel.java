package com.example.mvp.base;

public class BaseModel<P extends BasePresenter> {
    public P mPresenter;
    public BaseModel(P BasePresenter){
        this.mPresenter = BasePresenter;
    }
}
