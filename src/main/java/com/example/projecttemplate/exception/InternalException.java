package com.example.projecttemplate.exception;

import com.guigu.payment.enums.ExceptionEnum;

/**
 * @author xushengjie
 * @create 2022/4/29 4:47 PM
 */
public class InternalException extends RuntimeException {

	public InternalException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
	}
}
