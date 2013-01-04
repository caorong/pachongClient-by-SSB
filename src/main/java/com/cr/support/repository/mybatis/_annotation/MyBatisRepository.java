package com.cr.support.repository.mybatis._annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Description 以注解方式来标识MyBatis的DAO,
 * 				{@link org.mybatis.spring.mapper.MapperScannerConfigurer}进行扫描
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyBatisRepository {

}
