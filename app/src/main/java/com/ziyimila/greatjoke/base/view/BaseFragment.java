package com.ziyimila.greatjoke.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.factory.IPresenterFactory;
import com.ziyimila.greatjoke.base.factory.PresenterFactoryImpl;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.proxy.IPresenterProxy;
import com.ziyimila.greatjoke.base.proxy.PresenterProxyImpl;

/**
 * Created by Administrator on 2017/12/10.
 */

public abstract class BaseFragment<V extends IBaseView,P extends BasePresenter<V>> extends Fragment implements IPresenterProxy {

    private Context mContext;
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    /*
     * 创建被代理对象
     */
    private PresenterProxyImpl<V,P> mProxy = new PresenterProxyImpl<V,P>(PresenterFactoryImpl.<V,P>createFactory(getClass()));


    /**
     * 获得全局防止使用getActivity()为空
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i("BaseFragment onResume");
        mProxy.onResume((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("BaseFragment onDestroy");
        mProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.i("BaseFragment onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }


    /**
     * 设置自己的Presenter工厂
     * @param presenterFactory PresenterFactory类型
     */
    @Override
    public void setPresenterFactory(IPresenterFactory presenterFactory) {
        LogUtils.i("BaseFragment setPresenterFactory");
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public IPresenterFactory getPresenterFactory() {
        LogUtils.i("BaseFragment getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    public P getPresenter(){
        LogUtils.i("BaseFragment getPresenter");
        return mProxy.getPresenter();
    }

    /**
     * 执行数据的加载
     */
    protected abstract void initData();

    /**
     * 初始化view
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 获取onCreateView中的需要的layoutID
     * @return
     */
    protected abstract int getLayoutId();
    
}
