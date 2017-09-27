package com.fann.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by b1109_000 on 2017/9/8.
 */
public class JsonUtil {

    public static String toJson(Object o) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(o);
    }
}
