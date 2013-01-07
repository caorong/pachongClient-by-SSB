/**
 * 
 */
package com.cr.modules.weibo.service;

import java.util.HashMap;
import java.util.List;

import com.cr.modules.weibo.model.StatusBean;

/**
 * @Description	
 * @author caorong
 * @date 2013-1-7
 * 
 */
public interface StatusService {
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
}
