package com.yaoxun.dynamic.rw.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * 拦截使用了{@link DataSource}注解的目标
 * @author Loren
 * @date 2017年4月19日 下午5:18:07
 */
@Aspect
@Order(1)
public class DataSourceAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);
	
	@Before("@annotation(com.yaoxun.dynamic.rw.datasource.DataSource)")
	public void before(JoinPoint point) {
		// 获取到当前执行的方法名
		MethodSignature ms = (MethodSignature) point.getSignature();
		Method method = ms.getMethod();
		Class<DataSource> anno = DataSource.class;
		if (method.isAnnotationPresent(anno)) {
			DataSource data = method.getAnnotation(anno);
			DataSourceType value = data.value();
			LOGGER.debug("切换数据源，使用：{}",value.getName());
			DynamicDataSourceHolder.setDataSourceKey(value.getName());
		}
	}

}
