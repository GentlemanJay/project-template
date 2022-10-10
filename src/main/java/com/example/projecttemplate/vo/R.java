package com.example.projecttemplate.vo;

import com.guigu.payment.enums.ResultEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一封装返回(1)
 * @author xushengjie
 * @date 2022/9/23 15:45
 */
@Data
@Accessors(chain = true)
public class R implements Serializable {


    private static final long serialVersionUID = 1604584590920668957L;
    /**
     * 编码：200成功，0和其它数字为失败
     */
    private Integer code;

    /**
     * 请求结果信息
     */
    private String msg;


    /**
     * 动态数据
     */
    private Map<String, Object> data = new HashMap<>();



    public static R success() {
        R r = new R();
        r.setCode(ResultEnum.SUCCESS.getCode());
        r.setMsg(ResultEnum.SUCCESS.getDesc());
        return r;
    }



    public static R error() {
        R r = new R();
        r.setCode(ResultEnum.ERROR.getCode());
        r.setMsg(ResultEnum.ERROR.getDesc());
        return r;
    }


    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


}
