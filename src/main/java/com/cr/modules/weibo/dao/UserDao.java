package com.cr.modules.weibo.dao;

import com.cr.modules.weibo.model.UserBean;
import com.cr.support.repository.mybatis._annotation.MyBatisRepository;


@MyBatisRepository
public interface UserDao {
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
	
	/**
	 * @Description 更新User实例 一般是加type属性
	 * @param userBean
	 * @return  
	 * @author caorong
	 */	
	public void updateSingleUser(UserBean userBean);
}
