package com.cr.support.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.MDC;

/**
 * @Description log上下文监听器
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class LoggerContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//服务启动过程替换日志追踪号为SERVER
		MDC.put(TRACE_NO, "SERVER");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 日志追踪号
	 */
	private static final String TRACE_NO = "traceNo";

}
