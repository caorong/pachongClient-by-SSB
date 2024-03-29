package com.cr.modules.weibo.dao;

import java.util.HashMap;
import java.util.List;

import com.cr.modules.weibo.model.ReStatusBean;
import com.cr.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @description 转载dao
 * @author caorong
 * @date 2013-1-2
 */
@MyBatisRepository
public interface ReStatusDao {

	/**
	 * @Description 添加reStatus
	 * @param reStatusBean
	 * @return
	 * @author caorong
	 */
	public void insertReStatus(ReStatusBean reStatusBean);
	
	/**
	 * @Description 检验是否存在reStatus
	 * @param reStatusBean
	 * @return
	 * @author caorong
	 */
	public int queryReStatusByBean(ReStatusBean reStatusBean);
	
	/**
	 * @Description 取出满足相关条件的所有reStatus
	 * @param reStatusBean
	 * @return
	 * @author caorong
	 */
	public List<ReStatusBean> queryReStatusBeansByMap(HashMap<String, Object> map);
	
}
