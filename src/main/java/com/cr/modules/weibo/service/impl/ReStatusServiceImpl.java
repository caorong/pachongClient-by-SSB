/**
 * 
 */
package com.cr.modules.weibo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cr.modules.weibo.dao.ReStatusDao;
import com.cr.modules.weibo.model.ReStatusBean;
import com.cr.modules.weibo.service.ReStatusService;

/**
 * @Description	
 * @author caorong
 * @date 2013-1-7
 * 
 */
public class ReStatusServiceImpl implements ReStatusService {

	/* (non-Javadoc)
	 * @see com.cr.modules.weibo.service.ReStatusService#insertReStatus(com.cr.modules.weibo.model.ReStatusBean)
	 */
	@Override
	public void insertReStatus(ReStatusBean reStatusBean) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cr.modules.weibo.service.ReStatusService#queryReStatusByBean(com.cr.modules.weibo.model.ReStatusBean)
	 */
	@Override
	public int queryReStatusByBean(ReStatusBean reStatusBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cr.modules.weibo.service.ReStatusService#queryReStatusBeansByMap(java.util.HashMap)
	 */
	@Override
	public List<ReStatusBean> queryReStatusBeansByMap(
			HashMap<String, Object> map) {
		return reStatusDao.queryReStatusBeansByMap(map);
	}
	
	// 数据访问
	@Autowired
	private ReStatusDao reStatusDao;
}
