package com.ziyimila.greatjoke.base.proxy;

import com.ziyimila.greatjoke.base.factory.IPresenterFactory;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.view.IBaseView;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description 代理接口
 */

public interface IPresenterProxy<V extends IBaseView,P extends BasePresenter<V>> {

    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(IPresenterFactory<V,P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return 返回PresenterFactory类型
     */
    IPresenterFactory<V,P> getPresenterFactory();

    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     */
    P getPresenter();
}
