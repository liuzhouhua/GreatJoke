package com.ziyimila.greatjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ziyimila.greatjoke.base.annotation.CreatePresenter;
import com.ziyimila.greatjoke.test.RequestPresenter;

@CreatePresenter(RequestPresenter.class)
public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
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
                */
    }
}
