package com.example.mvp.login;

import com.example.mvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModel,LoginActivity,ILogin.VP>{
    @Override
    public LoginModel getModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                try {
                    mModel.getContract().requestLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseLoginResult(boolean isLoginStatusResult) {
                mView.getContract().responseLoginResult(isLoginStatusResult);
            }
        };
    }
/*
    @Override
    public void requestLogin(String name, String pwd) {
        try {
            mModel.requestLogin(name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void responseLoginResult(boolean isLoginStatusResult) {
        mView.responseLoginResult(isLoginStatusResult);
    }*/
}
