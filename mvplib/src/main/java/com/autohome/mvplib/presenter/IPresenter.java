package com.autohome.mvplib.presenter;

import com.autohome.mvplib.view.iview.IView;

/**
 * @author yangliqiang
 * @date 2017/3/22
 */
public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView(boolean retainInstance);
}
