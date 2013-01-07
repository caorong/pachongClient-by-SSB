package com.cr.modules.weibo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.cr.modules.weibo.model.StatusBean;
import com.cr.modules.weibo.model.UserBean;
import com.cr.modules.weibo.service.RelationPathService;
import com.cr.modules.weibo.service.StatusService;
import com.cr.modules.weibo.service.UserService;
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
	
	public ModelAndView quickSearchByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//从前台获取数据
		String str1 = this.findStringParameterValue(request, "iqnPostData");
		UserBean user= userService.querySingleUserByName(str1.trim());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uid", user.getUid());
		map.put("start", 0);
		map.put("offset", 10);
		List<StatusBean> modelList = statusService.queryStatuslistsByMap(map);
		
		return createMAV("weibo/weibo").addObject("modelList", modelList)
										.addObject("hidcurrentPage", 1);
	}
	
	public ModelAndView getStatusByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = this.findStringParameterValue(request, "hidUid");
		String currentPage = this.findStringParameterValue(request, "hidcurrentPage");
		
		int page = Integer.parseInt(currentPage);
		int start = (page-1)*10;
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("start", start);
		map.put("offset", 10);
		List<StatusBean> modelList = statusService.queryStatuslistsByMap(map);
		return createMAV("weibo/weibo").addObject("modelList", modelList)
				.addObject("hidcurrentPage", page+1);
	}
	
	//注入userService
	private UserService userService;
	private RelationPathService relationPathService;
	private StatusService statusService;

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRelationPathService(RelationPathService relationPathService) {
		this.relationPathService = relationPathService;
	}
}
