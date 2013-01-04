package com.cr.support.web.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * @Description 日志处理过滤器
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class LoggingProcessFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//用于拼接追踪号
		StringBuilder traceNoBuilder = new StringBuilder();
		//TODO：待有登录用户后取代此行代码  request.getSession().getAttribute("user");
		Object user = null;
//		LoginUser user = (LoginUser)request.getSession().getAttribute("user");
		//匿名用户
		if (user == null) {
			log.trace("cannot get user authentication.");
			traceNoBuilder.append(ANONYM).append("-");
			System.out.println("-----------------"+this.getClass().toString()+"---------");
		}/*else{
			log.info(user.toString());
			System.out.println(this.getClass().toString()+" 登陆  "+user.toString());
		}*/

		traceNoBuilder.append(new SimpleDateFormat(PATTERN).format(new Date()));
		log.trace("trace No.: {}", new Object[]{traceNoBuilder.toString()});
		//扩展日志追踪号
		MDC.put(TRACE_NO, traceNoBuilder.toString());
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}

	}
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 匿名用户(未登录)
	 */
	private static final String ANONYM = "anonym";
	
	private static final String PATTERN = "yyyyMMddHHmmSS";
	
	/**
	 * 日志追踪号
	 */
	private static final String TRACE_NO = "traceNo";

}
