package com.fann.utils;

import java.util.DoubleSummaryStatistics;

/**
 * Created by b1109_000 on 2017/9/9.
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
