package com.autohome.mvplib.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.autohome.mvplib.IMvpBase;
import com.autohome.mvplib.presenter.IPresenter;
import com.autohome.mvplib.view.iview.IView;

/**
 * MVP框架view层基类（针对单个presenter）
 *
 * @author yangliqiang
 * @date 2017/3/22
 */
public abstract class MVPActivity<V extends IView, P extends IPresenter<V>>
        extends Activity implements IView, IMvpBase<V> {
    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(getMvpView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    public abstract P createPresenter();

    @Override
    public V getMvpView() {
        return (V) this;
    }
}
