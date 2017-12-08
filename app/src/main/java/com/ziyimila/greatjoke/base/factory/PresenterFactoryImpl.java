package com.ziyimila.greatjoke.base.factory;

import com.ziyimila.greatjoke.base.annotation.CreatePresenter;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.view.IBaseView;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description Presenter的一个工厂实现类
 */

public class PresenterFactoryImpl<V extends IBaseView,P extends BasePresenter<V>> implements IPresenterFactory {

    //需要创建的Presenter的类型
    private final Class<P> mPresenterClass;

    private PresenterFactoryImpl(Class<P> presenterClass) {
        this.mPresenterClass = presenterClass;
    }

    @Override
    public P createPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e){
            throw  new RuntimeException("Presenter创建失败！,检测是否声明了@CreatePresenter(XX.class)注解");
        }
    }

    /**
     * 根据注解创建Presenter的工厂实现类
     * @param viewClass 需要创建Presenter的V层实现类
     * @param <V> 当前View实现的接口类型
     * @param <P> 当前要创建的Presenter的接口类型
     * @return 工厂类
     */
    public static <V extends IBaseView,P extends BasePresenter<V>> PresenterFactoryImpl<V,P> createFactory(Class<?> viewClass){
        CreatePresenter annotation = viewClass.getAnnotation(CreatePresenter.class);
        Class<P> pClass = null;
        if(annotation!=null){
            pClass = (Class<P>) annotation.value();
        }
        return pClass==null?null:new PresenterFactoryImpl<>(pClass);
    }
}
