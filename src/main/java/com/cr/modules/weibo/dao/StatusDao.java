package com.cr.modules.weibo.dao;

import java.util.HashMap;
import java.util.List;

import com.cr.modules.weibo.model.StatusBean;
import com.cr.support.repository.mybatis._annotation.MyBatisRepository;

@MyBatisRepository
public interface StatusDao {
	/**
	 * @Description 添加status
	 * @param statusBean
	 * @return
	 * @author caorong
	 */
	public int insertStatus(StatusBean status);

	/**
	 * @Description 查询记录是否存在
	 * @param wid
	 * @return
	 * @author caorong
	 */
	int queryCountByWid(String wid);
	
	/**
	 * @Description 查询记录By uid  (所有)
	 * @param uid
	 * @return
	 * @author caorong
	 */
	List<StatusBean> queryStatuslistsByUid(String uid);
	
	/**
	 * @Description 分页查询记录By uid  
	 * @param uid
	 * @return
	 * @author caorong
	 */
	List<StatusBean> queryStatuslistsByMap(HashMap<String, Object> map);
	
	/**
	 * @Description 查询单条记录 
	 * @param wid
	 * @return
	 * @author caorong
	 */
	StatusBean querySingleStatusByWid(String wid);
	
}
