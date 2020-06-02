package com.example.mvp.login;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter,ILogin.VP> {
    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mPresenter.getContract().requestLogin(name,pwd);
            }

            @Override
            public void responseLoginResult(boolean isLoginStatusResult) {

                Toast.makeText(LoginActivity.this, isLoginStatusResult?"Login successful":"Login failed", Toast.LENGTH_SHORT).show();
            }
        };
    }

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


 /*   @Override
    public void requestLogin(String name, String pwd) {
        mPresenter.requestLogin(name, pwd);
    }

    @Override
    public void responseLoginResult(boolean isLoginStatusResult) {
        Toast.makeText(this, "status" + isLoginStatusResult, Toast.LENGTH_SHORT).show();
    }*/

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String name = etUser.getText().toString();
        String pwd = etPassword.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
            Toast.makeText(this,"Wrong account name or password",Toast.LENGTH_SHORT).show();
            return;
        }
//        requestLogin(name,pwd);
        getContract().requestLogin(name,pwd);
    }
}
