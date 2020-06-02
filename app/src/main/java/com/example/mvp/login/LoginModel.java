package com.example.mvp.login;

        import com.example.mvp.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter,ILogin.M>{
    public LoginModel(LoginPresenter BasePresenter) {
        super(BasePresenter);
    }

    @Override
    public ILogin.M getContract() {
        return new ILogin.M() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                if(name.equals(pwd)){
                    mPresenter.getContract().responseLoginResult(true);
                }else {
                    mPresenter.getContract().responseLoginResult(false);
                }

            }
        };
    }


   /* @Override
    public void requestLogin(String name, String pwd) throws Exception {
        if(name.equals(pwd)){
            mPresenter.responseLoginResult(true);
        }else{
            mPresenter.responseLoginResult(false);
        }
    }*/
}
