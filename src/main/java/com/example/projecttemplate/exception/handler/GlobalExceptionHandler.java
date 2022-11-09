package com.example.projecttemplate.exception.handler;

import com.example.projecttemplate.enums.ResultEnum;
import com.example.projecttemplate.exception.CustomException;
import com.example.projecttemplate.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义全局异常
 * @author xushengjie
 * @create 2022/4/29 4:40 PM
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 全局异常处理方法
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result<String> exceptionHandler(Exception ex){
		log.error(ex.getMessage());
		return Result.error(ex.getMessage());
	}


	/**
	 * 参数校验异常拦截
	 * controller层添加@Validated注解
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<String> handleBindException(MethodArgumentNotValidException e) {
		String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		return Result.error(ResultEnum.ERROR.getCode(), defaultMessage);
	}


	/**
	 * 自定义处理异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(CustomException.class)
	public Result<String> handleCustomException(CustomException e) {
		log.error(e.getMessage(), e);
		return Result.error(e.getMessage());
	}
}
