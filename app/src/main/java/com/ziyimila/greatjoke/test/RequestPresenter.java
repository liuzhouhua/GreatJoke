package com.ziyimila.greatjoke.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.http.RetrofitFactory;
import com.ziyimila.greatjoke.http.bean.BaseEntity;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lzh27651 on 2017/12/8.
 */

public class RequestPresenter extends BasePresenter<RequestView> {


    public void getContextJoke(){
        RetrofitFactory.getInstance().API().getTextContentJoke("1","20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<TextContentJokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<TextContentJokeBean> textContentJokeBeanBaseEntity) {
                        if(textContentJokeBeanBaseEntity.getShowapi_res_code()==0){
                            Gson gson = new Gson();
                            String tr = gson.toJson(textContentJokeBeanBaseEntity.getShowapi_res_body().getContentlist().get(0),TextContentJokeBean.class);
                            LogUtils.d("成功 :"+tr);
                            getView().showText(tr);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onCreatePresenter(@Nullable Bundle saveState) {
        super.onCreatePresenter(saveState);
        if(saveState!=null){
            LogUtils.i("RequestPresenter onCreatePresenter 测试 = "+saveState.getString("test2"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        LogUtils.i("RequestPresenter onSaveInstanceState 测试 ");
        state.putString("test2","test_save2");
    }

    @Override
    public void onDestroyPresenter() {
        super.onDestroyPresenter();
    }
}
