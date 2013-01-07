package com.cr.modules.weibo.service;

import com.cr.modules.weibo.model.UserBean;

/**
 * @description usesr接口
 * @author caorong
 * @date 2013-1-4
 */
public interface UserService {
	/**
	 * @Description 添加user
	 * @param userBean
	 * @return
	 * @author caorong
	 */
	public int insertUser(UserBean user);	
	
	/**
	 * @Description 查询记录是否存在
	 * @param uid
	 * @return
	 * @author caorong
	 */
	public int queryCountByUid(String uid);
	
	/**
	 * @Description 获得一个User实例
	 * @param uid
	 * @return UserBean
	 * @author caorong
	 */	
	public UserBean querySingleUserByUid(String uid);
	
	public UserBean querySingleUserByName(String name);
}
