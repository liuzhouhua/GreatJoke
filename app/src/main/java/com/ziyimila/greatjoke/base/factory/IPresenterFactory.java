package com.ziyimila.greatjoke.base.factory;

import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.base.view.IBaseView;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description Presenter 工厂接口
 */

public interface IPresenterFactory<V extends IBaseView,P extends BasePresenter<V>> {

    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createPresenter();
}
