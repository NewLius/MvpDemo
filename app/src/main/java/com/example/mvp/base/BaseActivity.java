package com.example.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,CONTRACT> extends AppCompatActivity {

    public abstract CONTRACT getContract();

    public P mPresenter;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        mPresenter = getPresenterInstance();
        initView();
        initData();
        mPresenter.getModelInstance();
        mPresenter.bindView(this);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    protected abstract P getPresenterInstance();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        mPresenter.unBindView();
        onDestory();
    }

    protected void onDestory(){};
}
