package com.cr.support.exception.logger.context;

/**
 * @Description 异常日志上下文
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class ExceptionLoggerContext {

	public ExceptionLoggerContext(Throwable throwable){
		this.throwable = throwable;
	}
	
	private Throwable throwable;

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}
