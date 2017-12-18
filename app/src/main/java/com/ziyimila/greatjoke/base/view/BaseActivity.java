package com.ziyimila.greatjoke.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.factory.IPresenterFactory;
import com.ziyimila.greatjoke.base.factory.PresenterFactoryImpl;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.proxy.IPresenterProxy;
import com.ziyimila.greatjoke.base.proxy.PresenterProxyImpl;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description 指定子类具体的View必须继承自IBaseView
 * @description 指定子类具体的Presenter必须继承自BasePresenter
 * 使用代理模式来代理Presenter的创建、销毁、绑定、解绑以及Presenter的状态保存,其实就是管理Presenter的生命周期
 */

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>>
        extends AppCompatActivity implements IPresenterProxy {

    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    /*
     * 创建被代理对象
     */
    private PresenterProxyImpl<V,P> mProxy = new PresenterProxyImpl<V,P>(PresenterFactoryImpl.<V,P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i("BaseActivity onCreate");
        if(savedInstanceState!=null){
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i("BaseActivity onResume");
        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i("BaseActivity onDestroy");
        mProxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.i("BaseActivity onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    /**
     * 设置自己的Presenter工厂
     * @param presenterFactory PresenterFactory类型
     */
    @Override
    public void setPresenterFactory(IPresenterFactory presenterFactory) {
        LogUtils.i("BaseActivity setPresenterFactory");
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public IPresenterFactory getPresenterFactory() {
        LogUtils.i("BaseActivity getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    public P getPresenter(){
        LogUtils.i("BaseActivity getPresenter");
        return mProxy.getPresenter();
    }
}
