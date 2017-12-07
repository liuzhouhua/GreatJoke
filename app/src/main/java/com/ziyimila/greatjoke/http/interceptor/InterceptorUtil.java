package com.ziyimila.greatjoke.http.interceptor;

import com.ziyimila.greatjoke.http.config.HttpConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/12/1.
 * 拦截器工具类
 */

public class InterceptorUtil {
    public static String TAG = "InterceptorUtil";

    //日志拦截器
    public static Interceptor LogInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//全部数据
        return httpLoggingInterceptor;
    }

    //头部拦截器
    public static Interceptor HeaderInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mRequest = chain.request();
                //在这里你可以做一些想做的事情，比如token失效时，重新获取token
                //或者添加header等等。
                return chain.proceed(mRequest);
            }
        };
    }

    /**
     *封装公共参数应用签名和id
     * @return
     */
    public static Interceptor AppSignAndIdInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mOldRequest = chain.request();

                //添加固定参数
                HttpUrl.Builder authorizedUrlBuilder = mOldRequest.url()
                        .newBuilder()
                        .scheme(mOldRequest.url().scheme())
                        .host(mOldRequest.url().host())
                        .addQueryParameter(HttpConfig.SHOWAPI_APPID,HttpConfig.APP_ID)
                        .addQueryParameter(HttpConfig.SHOWAPI_SIGN,HttpConfig.SIGN);

                //新的参数
                Request mNewRequest = mOldRequest.newBuilder()
                        .method(mOldRequest.method(),mOldRequest.body())
                        .url(authorizedUrlBuilder.build())
                        .build();

                return chain.proceed(mNewRequest);
            }
        };
    }
}
