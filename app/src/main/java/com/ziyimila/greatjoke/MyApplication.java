package com.ziyimila.greatjoke;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;


/**
 * Created by Administrator on 2017/12/6.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder().tag("GreateJoke").build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static Context getmContext() {
        return mContext;
    }
}
