package com.ziyimila.greatjoke.http.base;

import com.ziyimila.greatjoke.http.bean.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/12/7.
 */

public class BaseObserver<T> implements Observer<BaseEntity<T>> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
