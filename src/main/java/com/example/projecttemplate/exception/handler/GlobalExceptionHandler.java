package com.example.projecttemplate.exception.handler;

import com.example.projecttemplate.enums.ExceptionEnum;
import com.example.projecttemplate.exception.CustomException;
import com.example.projecttemplate.exception.InternalException;
import com.example.projecttemplate.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 自定义全局异常
 * @author xushengjie
 * @create 2022/4/29 4:40 PM
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 异常处理方法
	 * @return
	 */
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
		log.error(ex.getMessage());

		if(ex.getMessage().contains("Duplicate entry")){
			return Result.error(ExceptionEnum.DATA_DUPLICATE.getCode(), ex.getMessage());
		}

		return Result.error(ExceptionEnum.DATA_INVALID.getCode(), ex.getMessage());
	}


	@ExceptionHandler(InternalException.class)
	@ResponseStatus(HttpStatus.OK)
	public Result<String> handleInternalException(InternalException e)
	{
		log.error(e.getMessage(), e);
		return Result.error(1008, e.getMessage());
	}


	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.OK)
	public Result<String> handleCustomException(CustomException e)
	{
		log.error(e.getMessage(), e);
		return Result.error(1007, e.getMessage());
	}
}
