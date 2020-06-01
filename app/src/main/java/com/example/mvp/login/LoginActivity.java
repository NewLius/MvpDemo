package com.example.mvp.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILogin.VP {
    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter getPresenterInstance() {
        return new LoginPresenter();
    }


    @Override
    public void requestLogin(String name, String pwd) {
        mPresenter.requestLogin(name, pwd);
    }

    @Override
    public void responseLoginResult(boolean isLoginStatusResult) {
        Toast.makeText(this, "status" + isLoginStatusResult, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String name = etUser.getText().toString();
        String pwd = etPassword.getText().toString();
        requestLogin(name,pwd);
    }
}
