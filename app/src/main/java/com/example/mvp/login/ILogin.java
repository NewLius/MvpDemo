package com.example.mvp.login;

public class ILogin {
    public interface M{
        void requestLogin(String name,String pwd) throws Exception;
    }

    public interface VP{
        void requestLogin(String name,String pwd);
        void responseLoginResult(boolean isLoginStatusResult);
    }
}
