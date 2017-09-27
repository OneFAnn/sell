package com.fann.utils;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by b1109_000 on 2017/8/1.
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
