package com.cr.support.exception.logger.closure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cr.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description 默认异常日志处理
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPDefaultExceptionLoggerClosure extends BaseClosure {

	@Override
	public void execute(Object input) {
		ExceptionLoggerContext context = this.toContext(input);
		log.error(context.getThrowable().getMessage(), context.getThrowable());
	}
	
	private transient Logger log = LoggerFactory.getLogger("defaultException");

}
