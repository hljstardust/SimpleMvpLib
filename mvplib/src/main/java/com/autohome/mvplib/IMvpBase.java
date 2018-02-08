package com.autohome.mvplib;

import com.autohome.mvplib.view.iview.IView;

/**
 * @author yangliqiang
 * @date 2017/3/22
 */
public interface IMvpBase<V extends IView> {
    V getMvpView();
}
