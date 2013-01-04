package com.cr.support.web.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.SwitchClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.cr.support.exception.logger.context.ExceptionLoggerContext;

/**
 * @Description 自定义映射异常解析器
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class CustomMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			
			//add by caobin
			log.error("====Error Type====: {}", new Object[]{ex.getClass()});
			
			//日志分类处理
			Closure loggerClosures = new SwitchClosure(predicates, closures, defaultClosure);
			loggerClosures.execute(new ExceptionLoggerContext(ex));
			
			return getModelAndView(viewName, ex, request).addObject("message", ex.getMessage());
		} else {
			return null;
		}
	}
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Predicate[] predicates;
	
	private Closure[] closures;
	
	private Closure defaultClosure;

	public void setPredicates(Predicate[] predicates) {
		this.predicates = predicates;
	}

	public void setClosures(Closure[] closures) {
		this.closures = closures;
	}

	public void setDefaultClosure(Closure defaultClosure) {
		this.defaultClosure = defaultClosure;
	}
	
	

}
