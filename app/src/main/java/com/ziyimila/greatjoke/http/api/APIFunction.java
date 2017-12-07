package com.ziyimila.greatjoke.http.api;

import com.ziyimila.greatjoke.http.bean.BaseEntity;
import com.ziyimila.greatjoke.http.bean.GifJokeBean;
import com.ziyimila.greatjoke.http.bean.ImageJokeBean;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/6.
 * API 接口
 */

public interface APIFunction {

    @FormUrlEncoded
    @POST("341-1")
    Observable<BaseEntity<TextContentJokeBean>> getTextContentJoke(@Field("page") String page,
                                                                   @Field("maxResult") String maxResult);

    @FormUrlEncoded
    @POST("341-2")
    Observable<BaseEntity<ImageJokeBean>> getImageJoke(@Field("page") String page,
                                                       @Field("maxResult") String maxResult);


    @FormUrlEncoded
    @POST("341-3")
    Observable<BaseEntity<GifJokeBean>> getGifJoke(@Field("page") String page,
                                                   @Field("maxResult") String maxResult);
}
