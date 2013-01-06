/**
 * 
 */
package com.cr.modules.weibo.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;



import com.cr.modules.weibo.model.RelationPathBean;
import com.cr.modules.weibo.model.UserBean;
import com.cr.modules.weibo.service.UserService;
import com.cr.support.web.controller.BaseController;

import com.wb.wb.weibo4j.Friendships;
import com.wb.wb.weibo4j.Oauth;
import com.wb.wb.weibo4j.http.AccessToken;
import com.wb.wb.weibo4j.model.Paging;
import com.wb.wb.weibo4j.model.User;
import com.wb.wb.weibo4j.model.UserWapper;
import com.wb.wb.weibo4j.model.WeiboException;
import com.wb.wb.weibo4j.util.BareBonesBrowserLaunch;


/**
 * @Description	
 * @author caorong
 * @date 2013-1-5
 * 
 */
public class UserRelationshipController extends BaseController {

	/**
	 * @Description 显示default样例页面  要求输入uid
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView userRelationshipDisplay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return createMAV("weibo/relationship");
	}

	/**
	 * @Description 显示default样例页面   画该uid的用户关系图
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView userRelatPrint(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*
		//进行oauth认证
		Oauth oauth = new Oauth();
		String code = null;
		try {
			BareBonesBrowserLaunch.openURL(oauth.authorize("code"));
			System.out.println(oauth.authorize("code"));
			System.out.print("Hit enter when it's done.[Enter]:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			code = br.readLine().trim();// 获得code
			log.info("code: " + code);
		} catch (WeiboException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AccessToken accessToken = null;
		
		try{
			accessToken = oauth.getAccessTokenByCode(code); 
			System.out.println(accessToken);
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				log.info("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
		//my uid: 1057297283    sm: 479016974
		String access_token = accessToken.getAccessToken();
		
		//谁的uid用户关系 
		String printedUid = "1057297283";
		//每层获取多少条
		int getRelationCount = 10;
		
		Friendships friendships = new Friendships();
		friendships.client.setToken(access_token);
		
		UserWapper userWapper = null;
		try {
			userWapper = friendships.getFriendsBilateral(printedUid, 0,
					new Paging(1, getRelationCount));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		List<User> lv1Users = userWapper.getUsers();

		//canvas 属性初始化
		List<RelationPathBean> relationlists = new ArrayList<RelationPathBean>();
		
		// lv1层坐标 start
		int xlv1s = 660;
		int ylv1s = 300;
		// end
		int xlv1e = 660;
		int ylv1e = 300;
		// lv2层坐标
		int xlv2s;
		int ylv2s;
		//end
		int xlv2e;
		int ylv2e;
		
		//半径 lv1&lv2 
		int rlv1 = 200;
		int rlv2 = 80;
		*/
		//中心点
		/**
		 * $(window).width();     1366.
		 * $(window).height();    600
		 * */
		/*
//		xlv1e = xlv1s + rlv1
		RelationPathBean relationPathBean = new RelationPathBean(printedUid,
				printedUid, 660 + "", 300 + "",660 + "", 300 + "", "曹融","10","0");
		relationlists.add(relationPathBean);
		//lv1 lv2  的个数  TODO: 可以根据length的大小来确定deep的大小 改变前台的圆大小
		int lengthlv1 = lv1Users.size();
		int lengthlv2;
		//循环变量
		int ilv1 = 0;
		int ilv2 = 0;
		//开始遍历1层
		for (User u1 : lv1Users) {
			//防止待检测的人
			if (u1 != null) {
				// 检测db里是否有这个User对象，有的话直接从db中获取
				if(userService.queryCountByUid(u1.getId()) != 0){
					//db中存在，从db获取啥
//					UserBean userlv1 = userService.querySingleUserByUid(u1.getId()); 
				} else {
					//db中不存在，将找到的人存进db
					this.insertUserToDb(u1);
				}
				//计算坐标
				xlv1s = 660;
				ylv1s = 300;
				xlv1e = (int)( xlv1s + rlv1* Math.cos(ilv1*(360/lengthlv1) * (Math.PI / 180)) );
				ylv1e = (int)( ylv1s + rlv1* Math.sin(ilv1*(360/lengthlv1) * (Math.PI / 180)) );
				ilv1++;
				
				// 创建并插入path队列
				RelationPathBean relatlv1 = new RelationPathBean(printedUid,
						u1.getId(), xlv1s + "", ylv1s + "", xlv1e + "", ylv1e + "", lengthlv1 + "", u1.getName(), "1");
				relationlists.add(relatlv1);
				//TODO : 将RelationPathBean插入db 使下次不必再调api直接调db
				
				//开始遍历2层
				try {
					userWapper = friendships.getFriendsBilateral(u1.getId(), 0,
							new Paging(1, getRelationCount));
				} catch (WeiboException e) {
					e.printStackTrace();
				}
				List<User> lv2Users = userWapper.getUsers();
				//2层的大小
				lengthlv2 = lv2Users.size();
				for(User u2 : lv2Users){
					//防止 注销
					if(u2 != null){
						// 检测db里是否有这个User对象，有的话直接从db中获取
						if(userService.queryCountByUid(u2.getId()) != 0){
							//db中存在，从db获取
							UserBean userlv2 = userService.querySingleUserByUid(u2.getId()); 
						} else {
							//db中不存在，将找到的人存进db
							this.insertUserToDb(u2);
						}
						//第一层的头是第二层的末尾  初始化
						xlv2s = xlv1e;
						ylv2s = ylv1e;
						xlv2e = (int)( xlv2s + rlv2* Math.cos(ilv2*(360/lengthlv2) * (Math.PI / 180)) );
						ylv2e = (int)( ylv2s + rlv2* Math.sin(ilv2*(360/lengthlv2) * (Math.PI / 180)) );
						ilv2++;
						//先检测list里是否已经有uid相同的人
						for(RelationPathBean retmp : relationlists){
							if(retmp.getUid().equals(u2.getId())){
								//修改他们end 让他们指向同一个end点,再插入
								xlv2e = Integer.parseInt(retmp.getXend());
								ylv2e = Integer.parseInt(retmp.getYend());
								break;
							}
						}
						//create and insert
						RelationPathBean relatlv2 = new RelationPathBean(printedUid, u2.getId(), xlv2s + "", ylv2s + "",
								xlv2e + "", ylv2e + "", lengthlv2 + "",u2.getName(), "2");
						relationlists.add(relatlv2);			
					}
				}		
			}
		}*/
		response.setCharacterEncoding("utf-8");        
	    response.setContentType("text/html; charset=utf-8");  
		response.getWriter().print("s");
		return null;
	}
	
	public ModelAndView ajaxTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		List<RelationPathBean> lists = new ArrayList<RelationPathBean>();
		lists.add(new RelationPathBean("Auid", "1uid", "1", "1", "100", "200", "曹rong","1"));
		lists.add(new RelationPathBean("Auid", "2uid", "100", "200", "200", "250", "曹rong2","2"));
		JSONArray jsonArray = JSONArray.fromObject(lists);
		response.setCharacterEncoding("utf-8");        
	    response.setContentType("text/html; charset=utf-8");  
		response.getWriter().print(jsonArray);
		return null;
	}
	

	
	/**
	 * 将User转换并插入db
	 * */
	public void insertUserToDb(User u){
		UserBean userBean = new UserBean();
		
		userBean.setUid(u.getId());
		userBean.setScreenName(u.getScreenName());
		userBean.setName(u.getName());
		userBean.setProvince(u.getProvince()+"");
		userBean.setCity(u.getCity()+"");
		
		userBean.setLocation(u.getLocation());
		userBean.setDescription(u.getDescription());
		userBean.setUrl(u.getUrl());
		userBean.setProfileImageUrl(u.getProfileImageUrl());
		userBean.setUserDomain(u.getUserDomain());
		
		userBean.setGender(u.getGender());
		userBean.setFollowersCount(u.getFollowersCount()+"");
		userBean.setFriendsCount(u.getFriendsCount()+"");
		userBean.setStatusesCount(u.getStatusesCount()+"");
		userBean.setFavouritesCount(u.getFavouritesCount()+"");
		
		userBean.setCreatedAt(u.getCreatedAt());
		String flag = "1";
		if(!u.isFollowing()){
			flag = "0";
		}
		userBean.setFollowing(flag);
		flag = "1";
		if(!u.isVerified()){
			flag = "0";
		}
		userBean.setVerified(flag);
		userBean.setVerifiedType(u.getverifiedType()+"");
		flag = "1";
		if(!u.isAllowAllActMsg()){
			flag = "0";
		}
		userBean.setAllowAllActMsg(flag);
		
		flag = "1";
		if(!u.isallowAllComment()){
			flag = "0";
		}
		userBean.setAllowAllComment(flag);
		flag = "1";
		if(!u.isFollowMe()){
			flag = "0";
		}
		userBean.setFollowMe(flag);
		userBean.setAvatarLarge(u.getAvatarLarge());
		userBean.setBiFollowersCount(u.getBiFollowersCount()+"");
		userBean.setRemark(u.getRemark());
		
		userBean.setLang(u.getLang());
		userBean.setVerifiedReason(u.getVerifiedReason());
		userBean.setWeihao(u.getWeihao());
		
		userService.insertUser(userBean);
	}
	
	//注入userService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
