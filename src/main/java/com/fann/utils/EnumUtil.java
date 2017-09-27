package com.fann.utils;

import com.fann.enums.CodeEnum;

/**
 * Created by b1109_000 on 2017/9/11.
 */
public class EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code,Class<T> enumClass) {
        if (code == null) {
            return null;
        }
        for (T each : enumClass.getEnumConstants()) {
            if (each.getCode().equals(code)) {
                return each;
            }
        }
        return null;
    }
}
