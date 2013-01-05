/**
 * 
 */
package com.cr.modules.weibo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cr.modules.weibo.dao.UserDao;
import com.cr.modules.weibo.model.UserBean;
import com.cr.modules.weibo.service.UserService;

/**
 * @Description	
 * @author caorong
 * @date 2013-1-5
 * 
 */
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	// 此处使用注解事务来保证事务的ACID
	// MyBatis的事务通过默认传播级别会加入spring的事务并受到spring容器的管理
	@Transactional(readOnly=false)
	@Override
	public int insertUser(UserBean user) {
		userDao.insertUser(user);
		return 0;
	}

 
	@Override
	public int queryCountByUid(String uid) {
		userDao.queryCountByUid(uid);
		return 0;
	}
 
	@Override
	public UserBean querySingleUserByUid(String uid) {
		return userDao.querySingleUserByUid(uid);
	}

	// 数据访问
	@Autowired
	private UserDao userDao;
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
		
}
