package com.ziyimila.greatjoke.home.presenter;

import com.google.gson.Gson;
import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.presenter.BasePresenter;
import com.ziyimila.greatjoke.http.RetrofitFactory;
import com.ziyimila.greatjoke.http.bean.BaseEntity;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;
import com.ziyimila.greatjoke.home.view.JokeRequestView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/18.
 */

public class JokeRequestPresenter extends BasePresenter<JokeRequestView> {
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
                            getView().updateData(textContentJokeBeanBaseEntity.getShowapi_res_body().getContentlist());
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
}
