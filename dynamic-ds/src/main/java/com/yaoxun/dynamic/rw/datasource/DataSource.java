package com.yaoxun.dynamic.rw.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置service使用的数据源
 * 
 * @author Loren
 * @date 2017年4月19日 下午5:17:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
	/**
	 * 默认使用Master库，{@link DataSourceType}
	 * @return
	 */
	DataSourceType value() default DataSourceType.MASTER;
}
