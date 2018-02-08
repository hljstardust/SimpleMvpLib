package com.autohome.mvplib.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.autohome.mvplib.IMvpBase;
import com.autohome.mvplib.presenter.IPresenter;
import com.autohome.mvplib.view.iview.IView;

/**
 * MVP框架view层基类（针对单个presenter）
 *
 * @author yangliqiang
 * @date 2017/3/22
 */
public abstract class MVPFragment<V extends IView, P extends IPresenter<V>> extends Fragment
        implements IView, IMvpBase<V> {
    protected P presenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }

        presenter.attachView(getMvpView());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView(getRetainInstance());
    }

    protected abstract P createPresenter();

    @Nullable
    @Override
    public V getMvpView() {
        return (V) this;
    }
}
