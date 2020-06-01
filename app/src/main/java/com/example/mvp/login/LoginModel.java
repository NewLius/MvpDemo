package com.example.mvp.login;

        import com.example.mvp.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter> implements ILogin.M{
    public LoginModel(LoginPresenter BasePresenter) {
        super(BasePresenter);
    }

    @Override
    public void requestLogin(String name, String pwd) throws Exception {
        if(name.equals(pwd)){
            mPresenter.responseLoginResult(true);
        }else{
            mPresenter.responseLoginResult(false);
        }
    }
}
