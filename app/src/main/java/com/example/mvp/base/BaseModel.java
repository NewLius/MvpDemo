package com.example.mvp.base;

public abstract class BaseModel<P extends BasePresenter,CONTRACT> extends SuperBase<CONTRACT>{
    public P mPresenter;
    public BaseModel(P BasePresenter){
        this.mPresenter = BasePresenter;
    }
}
