package com.example.projecttemplate.vo;

import com.example.projecttemplate.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一封装返回(2)
 * @author xushengjie
 * @date 2022/9/23 15:45
 */
@Data
public class Result<T> implements Serializable {


    private static final long serialVersionUID = 1604584590920668957L;
    /**
     * 编码：200成功，0和其它数字为失败
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;


    public static <T> Result<T> success(T object) {
        Result<T> r = new Result<>();
        if (object != null) {
            r.data = object;
        }
        r.code = ResultEnum.SUCCESS.getCode();
        r.msg = ResultEnum.SUCCESS.getDesc();
        return r;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> r = new Result<>();
        r.msg = msg;
        r.code = ResultEnum.ERROR.getCode();
        return r;
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> r = new Result<>();
        r.msg = msg;
        r.code = code;
        return r;
    }


}
