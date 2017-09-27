package com.fann.utils;

import com.fann.vo.ResultVo;

/**
 * Created by b1109_000 on 2017/7/31.
 */
public class ResultVoUtil {

    public static ResultVo success(Object o){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(o);
        resultVo.setMsg("成功");
        resultVo.setCode(0);
        return  resultVo;
    }
    public static ResultVo success(){

        return  success(null);
    }

    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setCode(code);
        return  resultVo;
    }
}
