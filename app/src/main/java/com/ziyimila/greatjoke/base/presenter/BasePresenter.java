package com.ziyimila.greatjoke.base.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.view.IBaseView;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description 指定绑定的view必须是继承自IBaseView
 * @description 带有生命周期的Presenter
 */

public class BasePresenter<T extends IBaseView> {

    /**
     * V层view
     */
    private T mBaseView;

    /**
     *Presenter被创建后调用
     * @param saveState
     */
    public void onCreatePresenter(@Nullable Bundle saveState){
        LogUtils.i("onCreatePresenter");
    }


    /**
     * 绑定V层
     * @param view
     */
    public void onAttachView(T view){
        this.mBaseView = view;
        LogUtils.i("onResume(onAttachView)");
    }

    /**
     * 解除绑定V层
     */
    public void onDetachView(){
        this.mBaseView = null;
        LogUtils.i("onDetachView");
    }


    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPresenter(){
        LogUtils.i("onDestroyPresenter");
    }

    /**
     * 在Presenter意外被销毁的时候调用
     * 它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     * @param state
     */
    public void onSaveInstanceState(Bundle state){
        LogUtils.i("onSaveInstanceState");
    }

    /**
     * 获取V层
     * @return
     */
    public T getView(){
        return this.mBaseView;
    }
}
