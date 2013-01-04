package com.cr.support.exception.logger.predicate;

import org.apache.commons.collections.Predicate;

import com.cr.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description predicate抽象基类
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public abstract class BasePredicate implements Predicate{

	/**
	 * @Description 输入obj转为异常日志上下文
	 * @param input
	 * @return
	 * @author caobin
	 */
	protected ExceptionLoggerContext toContext(Object input){
		return  input == null ? new ExceptionLoggerContext(null) : (ExceptionLoggerContext)input;
	}

}
