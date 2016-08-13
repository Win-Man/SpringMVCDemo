package com.sg.web.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;


/**
 * Created by sg on 2016/7/20.
 */
public class JsonUtils {
    private static Gson gson  = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public JsonUtils(){}

    public static String toJson(Object obj){
        return toJson(obj,gson);
    }

    public static String toJson(Object obj,Gson gson){
        return gson.toJson(obj);
    }

    public static Map toMap(String jsonStr){
        return gson.fromJson(jsonStr,Map.class);
    }

}
