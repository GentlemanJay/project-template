package com.example.projecttemplate.enums;

import lombok.Getter;

/**
 * 请求结果枚举类
 * @author xushengjie
 * @date 2022/9/23 16:12
 */
@Getter
public enum ResultEnum {

    /**
     * 访问成功
     */
    SUCCESS(200, "成功"),

    /**访问失败
     *
     */
    ERROR(500, "失败");

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;


    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
