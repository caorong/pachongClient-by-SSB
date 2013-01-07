/**
 * 
 */
package com.cr.modules.weibo.service;

import java.util.HashMap;
import java.util.List;

import com.cr.modules.weibo.model.ReStatusBean;

/**
 * @Description
 * @author caorong
 * @date 2013-1-7
 * 
 */
public interface ReStatusService {
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
