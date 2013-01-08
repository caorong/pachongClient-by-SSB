package com.cr.modules.weibo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;

import com.cr.modules.weibo.model.ReStatDeepPosBean;
import com.cr.modules.weibo.model.ReStatusBean;
import com.cr.modules.weibo.model.StatusBean;
import com.cr.modules.weibo.model.UserBean;
import com.cr.modules.weibo.service.ReStatusService;
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
		map.put("offset", 5);
		List<StatusBean> modelList = statusService.queryStatuslistsByMap(map);
		
		return createMAV("weibo/weibo").addObject("modelList", modelList)
										.addObject("hidcurrentPage", 1)
										.addObject("modeluid",modelList.get(0).getUid());
	}
	
	public ModelAndView getStatusByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = this.findStringParameterValue(request, "hidUid");
		String currentPage = this.findStringParameterValue(request, "hidcurrentPage");
		
		
		int page = Integer.parseInt(currentPage);
		int start = (page-1)*5;
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("start", start);
		map.put("offset", 5);
		List<StatusBean> modelList = statusService.queryStatuslistsByMap(map);
		return createMAV("weibo/weibo").addObject("modelList", modelList)
				.addObject("modeluid",modelList.get(0).getUid())
				.addObject("hidcurrentPage", page+1);
	}

	public ModelAndView getReStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wid = this.findStringParameterValue(request, "postwid");
		String authorfansflag = this.findStringParameterValue(request, "authorfansflag");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		//返回的list
		List<ReStatDeepPosBean> reStatBeanslists = new ArrayList<ReStatDeepPosBean>();
		//获取rootNode
		StatusBean rootStatus = statusService.querySingleStatusByWid(wid);
		UserBean rootUser = userService.querySingleUserByUid(rootStatus.getUid());
		reStatBeanslists.add(new ReStatDeepPosBean(rootStatus.getWid(), rootUser.getName(), null, null));
		//不关注作者深度图
		if(authorfansflag.equals("0")){
			map.put("authorfansflag", "0");
		}else{
			map.put("authorfansflag", "1");
		}
		map.put("fatherwid", wid);
		map.put("wid", wid);
		map.put("deepth", "1");
		List<ReStatusBean>relistslv1 = reStatusService.queryReStatusBeansByMap(map);
		//如果查出来为空则说明没有
		if(!relistslv1.isEmpty()){
			for(ReStatusBean r1 : relistslv1){
				//先将r1的位置bean放进返回的list
				//取出userid相应的name
				UserBean u1 = userService.querySingleUserByUid(r1.getSelfuid());
				//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
				if (u1 == null) {
					reStatBeanslists.add(new ReStatDeepPosBean(r1.getSelfwid(),"未抓取", 1+"", r1.getFatherwid()));
				} else {
					reStatBeanslists.add(new ReStatDeepPosBean(r1.getSelfwid(),u1.getName(), 1+"", r1.getFatherwid()));
				}
				//初始化第二层的属性
				map.clear();
				if(authorfansflag.equals("0")){
					map.put("authorfansflag", "0");
				}else{
					map.put("authorfansflag", "1");
				}
				map.put("wid", wid);
				map.put("fatherwid", r1.getWid());
				map.put("deepth", "2");
				//遍历第二层
				List<ReStatusBean>relistslv2 = reStatusService.queryReStatusBeansByMap(map);
				if(!relistslv2.isEmpty()){
					//第二层存在的话
					for(ReStatusBean r2 : relistslv2){
						UserBean u2 = userService.querySingleUserByUid(r2.getSelfuid());
						//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
						if (u2 == null) {
							reStatBeanslists.add(new ReStatDeepPosBean(r2.getSelfwid(), "未抓取", 3+"", r2.getFatherwid()));
						} else {
							reStatBeanslists.add(new ReStatDeepPosBean(r2.getSelfwid(), u2.getName(), 3+"", r2.getFatherwid()));
						}
						
						//初始化第三层的属性
						map.clear();
						if(authorfansflag.equals("0")){
							map.put("authorfansflag", "0");
						}else{
							map.put("authorfansflag", "1");
						}
						map.put("wid", wid);
						map.put("fatherwid", r2.getWid());
						map.put("deepth", "3");
						//遍历第三层
						List<ReStatusBean>relistslv3 = reStatusService.queryReStatusBeansByMap(map);
						if(!relistslv3.isEmpty()){
							//第三层存在的话
							for(ReStatusBean r3 : relistslv3){
								UserBean u3 = userService.querySingleUserByUid(r3.getSelfuid());
								//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
								if (u3 == null) {
									reStatBeanslists.add(new ReStatDeepPosBean(r3.getSelfwid(), "未抓取", 7+"", r3.getFatherwid()));
								} else {
									reStatBeanslists.add(new ReStatDeepPosBean(r3.getSelfwid(), u3.getName(), 7+"",r3.getFatherwid()));
								}
							}
						}
					}
				}
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(reStatBeanslists);
		response.setCharacterEncoding("utf-8");        
	    response.setContentType("text/html; charset=utf-8");  
		response.getWriter().print(jsonArray);
		
		return null;
	}
	
	//至少2层的才能出来
	public ModelAndView getReStatuslevel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wid = this.findStringParameterValue(request, "postwid");
		String authorfansflag = this.findStringParameterValue(request, "authorfansflag");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		//返回的list
		List<ReStatDeepPosBean> reStatBeanslists = new ArrayList<ReStatDeepPosBean>();
		//获取rootNode
		StatusBean rootStatus = statusService.querySingleStatusByWid(wid);
		UserBean rootUser = userService.querySingleUserByUid(rootStatus.getUid());
		reStatBeanslists.add(new ReStatDeepPosBean(rootStatus.getWid(), rootUser.getName(), null, null));
		//不关注作者深度图
		if(authorfansflag.equals("0")){
			map.put("authorfansflag", "0");
		}else{
			map.put("authorfansflag", "1");
		}
		map.put("fatherwid", wid);
		map.put("wid", wid);
		map.put("deepth", "1");
		List<ReStatusBean>relistslv1 = reStatusService.queryReStatusBeansByMap(map);
		//如果查出来为空则说明没有
		if(!relistslv1.isEmpty()){
			for(ReStatusBean r1 : relistslv1){
				int flag1 = 0;
				//先将r1的位置bean放进返回的list
				//初始化第二层的属性
				map.clear();
				if(authorfansflag.equals("0")){
					map.put("authorfansflag", "0");
				}else{
					map.put("authorfansflag", "1");
				}
				map.put("wid", wid);
				map.put("fatherwid", r1.getSelfwid());
				map.put("deepth", "2");
				//遍历第二层
				List<ReStatusBean>relistslv2 = reStatusService.queryReStatusBeansByMap(map);
				if(!relistslv2.isEmpty()){
					//取出userid相应的name
					UserBean u1 = userService.querySingleUserByUid(r1.getSelfuid());
					//进入第二层说明第二层非空 则可以插入 再遍历
					//检测 list里是否已经有这个id的数据
					for (ReStatDeepPosBean r : reStatBeanslists) {
						if(r.getId().equals(r1.getSelfwid()))
							flag1 = 1;
					}
					//不进行此次add
					if(flag1 == 1){
						//还原
						flag1 = 0;
						continue;
					}
					//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
					if (u1 == null) {
						reStatBeanslists.add(new ReStatDeepPosBean(r1.getSelfwid(),"未抓取", 1+"", r1.getFatherwid()));
					} else {
						reStatBeanslists.add(new ReStatDeepPosBean(r1.getSelfwid(),u1.getName(), 1+"", r1.getFatherwid()));
					}
					//第二层存在的话
					for(ReStatusBean r2 : relistslv2){
						int flag2 = 0;
						//初始化第三层的属性
						map.clear();
						if(authorfansflag.equals("0")){
							map.put("authorfansflag", "0");
						}else{
							map.put("authorfansflag", "1");
						}
						map.put("wid", wid);
						map.put("fatherwid", r2.getSelfwid());
						map.put("deepth", "3");
						//遍历第三层
						List<ReStatusBean>relistslv3 = reStatusService.queryReStatusBeansByMap(map);
						if(!relistslv3.isEmpty()){
							UserBean u2 = userService.querySingleUserByUid(r2.getSelfuid());
							//检测 list里是否已经有这个id的数据
							for (ReStatDeepPosBean r : reStatBeanslists) {
								if(r.getId().equals(r2.getSelfwid()))
									flag2 = 1;
							}
							//不进行此次add
							if(flag2 == 1){
								//还原
								flag2 = 0;
								continue;
							}
							//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
							if (u2 == null) {
								reStatBeanslists.add(new ReStatDeepPosBean(r2.getSelfwid(), "未抓取", 3+"", r2.getFatherwid()));
							} else {
								reStatBeanslists.add(new ReStatDeepPosBean(r2.getSelfwid(), u2.getName(), 3+"", r2.getFatherwid()));
							}
							//第三层存在的话
							for(ReStatusBean r3 : relistslv3){
								int flag3 = 0;
								UserBean u3 = userService.querySingleUserByUid(r3.getSelfuid());
								//检测 list里是否已经有这个id的数据
								for (ReStatDeepPosBean r : reStatBeanslists) {
									if(r.getId().equals(r3.getSelfwid()))
										flag3 = 1;
								}
								//不进行此次add
								if(flag3 == 1){
									//还原
									flag3 = 0;
									continue;
								}
								//这里是因为测试时数据不一致，因为之前抓的时候没  "物尽其用"
								if (u3 == null) {
									reStatBeanslists.add(new ReStatDeepPosBean(r3.getSelfwid(), "未抓取", 7+"", r3.getFatherwid()));
								} else {
									reStatBeanslists.add(new ReStatDeepPosBean(r3.getSelfwid(), u3.getName(), 7+"",r3.getFatherwid()));
								}
							}
						}
					}
				}
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(reStatBeanslists);
		response.setCharacterEncoding("utf-8");        
	    response.setContentType("text/html; charset=utf-8");  
		response.getWriter().print(jsonArray);
		
		return null;
	}
	
	//注入userService
	private UserService userService;
	private RelationPathService relationPathService;
	private StatusService statusService;
	private ReStatusService reStatusService;

	
	
	public void setReStatusService(ReStatusService reStatusService) {
		this.reStatusService = reStatusService;
	}

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
