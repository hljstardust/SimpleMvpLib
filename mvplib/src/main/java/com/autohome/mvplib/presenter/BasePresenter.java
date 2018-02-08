package com.autohome.mvplib.presenter;

import android.os.Bundle;

import com.autohome.mvplib.view.iview.IView;

import java.lang.ref.WeakReference;

/**
 * MVP基础Presenter
 *
 * @author yangliqiang
 * @date 2017/3/22
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {

    private WeakReference<V> viewRef;

    @Override
    public void attachView(IView view) {
        viewRef = new WeakReference<V>((V) view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 获取 presenter 对应的view
     *
     * @return 如果对应, 返回对应实例, 否则返回 null
     */
    public V getView() {
        return isViewAttached() ? viewRef.get() : null;
    }

    /**
     * 检查 presenter 是否存在对应View
     *
     * @return 如果存在返回true, 否则返回false
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    public void onSaveInstanceState(Bundle outState){

    }

    public void onRestoreInstanceState(Bundle outState){

    }
}
