package com.example.projecttemplate.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 * 实现公共字段自动填充
 * @author xushengjie
 * @create 2022/5/1 12:06 PM
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 设置新增插入操作，公共字段自动填充
	 * @TableField(fill = FieldFill.INSERT)
	 * @param metaObject
	 */
	@Override
	public void insertFill(MetaObject metaObject) {

		log.info("====新增操作---公共字段自动填充");

		metaObject.setValue("createTime", LocalDateTime.now());
		metaObject.setValue("updateTime", LocalDateTime.now());

	}

	/**
	 * 设置修改操作，公共字段自动填充
	 * @TableField(fill = FieldFill.INSERT_UPDATE)
	 * @param metaObject
	 */
	@Override
	public void updateFill(MetaObject metaObject) {

		log.info("====更新操作---公共字段自动填充");
		metaObject.setValue("updateTime", LocalDateTime.now());
	}
}
