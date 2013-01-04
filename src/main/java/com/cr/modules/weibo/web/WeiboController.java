package com.cr.modules.weibo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.cr.support.web.controller.BaseController;

/**
 * @description
 * @author caorong
 * @date 2013-1-4
 */
public class WeiboController extends BaseController {
	
	/**
	 * @Description 显示default样例页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView weiboDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return createMAV("weibo/weibo");
	}
	
}
