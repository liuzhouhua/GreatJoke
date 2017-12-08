package com.ziyimila.greatjoke.base.proxy;

import android.os.Bundle;

import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.factory.IPresenterFactory;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.view.IBaseView;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description 代理实现类，用来管理Presenter的生命周期，还有跟View之间的关联
 */

public class PresenterProxyImpl<V extends IBaseView,P extends BasePresenter<V>> implements IPresenterProxy<V,P> {

    /**
     * 获取onSaveInstanceState中Bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    /**
     * Presenter工厂类
     */
    private IPresenterFactory<V,P> presenterFactory;
    //Presenter
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttachView;

    public PresenterProxyImpl(IPresenterFactory<V, P> presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    /**
     * 设置Presenter的工厂类
     * 这个方法只能在创建Presenter之前调用,也就是调用getPresenter()之前，
     * 如果Presenter已经创建则不能再修改
     * @param presenterFactory PresenterFactory类型
     */
    @Override
    public void setPresenterFactory(IPresenterFactory<V,P> presenterFactory) {
        if(mPresenter!=null){
            throw new IllegalArgumentException("这个方法只能在getPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.presenterFactory = presenterFactory;
    }

    /**
     * 获取Presenter的工厂类
     * @return PresenterFactory类型
     */
    @Override
    public IPresenterFactory<V,P> getPresenterFactory() {
        return presenterFactory;
    }

    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     * 如果之前创建过，而且还是从销毁则从Bundle中恢复
     */
    @Override
    public P getPresenter() {
        LogUtils.i("Proxy getPresenter");
        if(mPresenter==null && !mIsAttachView){
            mPresenter = presenterFactory.createPresenter();
            mPresenter.onCreatePresenter(mBundle==null?null:mBundle.getBundle(PRESENTER_KEY));
        }
        LogUtils.i("Proxy getPresenter = "+mPresenter);
        return mPresenter;
    }

    /**
     * 绑定Presenter和View
     * @param view
     */
    public void onResume(V view){
        getPresenter();
        LogUtils.i("Proxy onResume");
        if (mPresenter!=null && !mIsAttachView){
            mPresenter.onAttachView(view);
            mIsAttachView = true;
        }
    }

    /**
     * 销毁Presenter持有的view
     */
    public void onDetachView(){
        LogUtils.i("Proxy onDetachView");
        if(mPresenter!=null){
            mPresenter.onDetachView();
            mIsAttachView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy(){
        LogUtils.i("Proxy onDestroy");
        if(mPresenter!=null){
            onDetachView();
            mPresenter.onDestroyPresenter();
            mPresenter = null;
        }
    }

    /**
     * 意外销毁的时候调用
     * @return 存入回调给Presenter的Bundle和当前Presenter的id
     */
    public Bundle onSaveInstanceState(){
        LogUtils.i("Proxy onSaveInstanceState");
        Bundle bundle = new Bundle();
        getPresenter();
        if(mPresenter!=null){
            Bundle presenterBundle = new Bundle();
            //
            // 填入数据
            //
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY,presenterBundle);
        }
        return bundle;
    }

    /**
     * 意外关闭恢复Presenter
     * @param saveInstanceState 意外关闭时存储的Bundle
     * @return
     */
    public void onRestoreInstanceState(Bundle saveInstanceState){
        LogUtils.i("Proxy onRestoreInstanceState");
        mBundle = saveInstanceState;
    }
}
