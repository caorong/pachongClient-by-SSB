package com.cr.support.exception.logger.predicate;

import com.cr.support.exception.PSFPBusinessException;
import com.cr.support.exception.PSFPRuntimeBusinessException;
import com.cr.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description 业务异常日志处理分支条件
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPBusinessExceptionLoggerPredicate extends BasePredicate {

	@Override
	public boolean evaluate(Object object) {
		ExceptionLoggerContext context = this.toContext(object);
		return 
			(context.getThrowable() instanceof PSFPBusinessException
					|| context.getThrowable() instanceof PSFPRuntimeBusinessException); 
				
	}

}
