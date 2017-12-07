package com.ziyimila.greatjoke.http;

import com.ziyimila.greatjoke.http.api.APIFunction;
import com.ziyimila.greatjoke.http.config.HttpConfig;
import com.ziyimila.greatjoke.http.interceptor.InterceptorUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/30.
 */

public class RetrofitFactory {

    private static RetrofitFactory mRetrofitFactory;
    private static APIFunction mApiFunction;

    private RetrofitFactory(){
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(HttpConfig.HTTP_TIME,TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(HttpConfig.HTTP_TIME,TimeUnit.SECONDS)//设置写入超时时间
//                .addInterceptor(InterceptorUtil.HeaderInterceptor())//添加头部拦截器
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .addInterceptor(InterceptorUtil.AppSignAndIdInterceptor())//添加公共参数
                .build();


        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加json转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加RxJava转换器
                .client(mOkHttpClient)
                .build();

        mApiFunction = mRetrofit.create(APIFunction.class);
    }

    public static RetrofitFactory getInstance(){
        if(mRetrofitFactory==null){
            synchronized (RetrofitFactory.class){
                if(mRetrofitFactory==null){
                    mRetrofitFactory = new RetrofitFactory();
                }
            }
        }
        return mRetrofitFactory;
    }

    public APIFunction API(){
        return mApiFunction;
    }
}
