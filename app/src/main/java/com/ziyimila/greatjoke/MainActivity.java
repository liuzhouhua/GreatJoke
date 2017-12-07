package com.ziyimila.greatjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.http.RetrofitFactory;
import com.ziyimila.greatjoke.http.bean.BaseEntity;
import com.ziyimila.greatjoke.http.bean.GifJokeBean;
import com.ziyimila.greatjoke.http.bean.ImageJokeBean;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        RetrofitFactory.getInstance().API().getImageJoke("1","20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<ImageJokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<ImageJokeBean> imageJokeBeanBaseEntity) {
                        if(imageJokeBeanBaseEntity.getShowapi_res_code()==0){
                            Gson gson = new Gson();
                            String tr = gson.toJson(imageJokeBeanBaseEntity.getShowapi_res_body().getContentlist().get(0),ImageJokeBean.class);
                            LogUtils.d("成功 :"+tr);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RetrofitFactory.getInstance().API().getGifJoke("1","20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<GifJokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<GifJokeBean> gifJokeBeanBaseEntity) {
                        if(gifJokeBeanBaseEntity.getShowapi_res_code()==0){
                            Gson gson = new Gson();
                            String tr = gson.toJson(gifJokeBeanBaseEntity.getShowapi_res_body().getContentlist().get(0),GifJokeBean.class);
                            LogUtils.d("成功 :"+tr);
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
