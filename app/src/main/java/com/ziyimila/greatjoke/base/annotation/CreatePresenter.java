package com.ziyimila.greatjoke.base.annotation;

import com.ziyimila.greatjoke.base.presenter.BasePresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lzh27651 on 2017/12/8.
 * @description 标注创建Presenter的注解
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BasePresenter> value();
}
