package com.ziyimila.greatjoke.Utils;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/12/1.
 */

public class LogUtils {

    /**
     * 支持打印MAP、SET、LIST、Array、String
     * @param args
     */
    public static void d(Object args){
        Logger.d(args);
    }

    /**
     * 打印格式字符串
     * @param message "hello %s"
     * @param args "world"
     */
    public static void d(String message, Object... args){
        Logger.d(message,args);
    }

    public static void i(String message,Object... args){
        Logger.i(message,args);
    }

    public static void e(String message,Object... args){
        Logger.e(message,args);
    }

    public static void w(String message,Object... args){
        Logger.w(message,args);
    }

    public static void v(String message,Object... args){
        Logger.v(message,args);
    }

    /**
     * 打印json
     * @param jsonContent
     */
    public static void json(String jsonContent){
        Logger.json(jsonContent);
    }


    /**
     * 打印xml
     * @param xmlContent
     */
    public static void xml(String xmlContent){
        Logger.xml(xmlContent);
    }

}
