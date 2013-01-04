package com.cr.support.exception.logger.predicate;

import com.cr.support.exception.PSFPRuntimeSystemException;
import com.cr.support.exception.PSFPSystemException;
import com.cr.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description 系统异常日志处理分支条件 
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPSystemExceptionLoggerPredicate extends BasePredicate {

	@Override
	public boolean evaluate(Object object) {
		ExceptionLoggerContext context = this.toContext(object);
		return 
			(context.getThrowable() instanceof PSFPSystemException
					|| context.getThrowable() instanceof PSFPRuntimeSystemException); 
				
	}

}
