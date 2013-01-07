/**
 * 
 */
package com.cr.modules.weibo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cr.modules.weibo.dao.StatusDao;
import com.cr.modules.weibo.model.StatusBean;
import com.cr.modules.weibo.service.StatusService;

/**
 * @Description	
 * @author caorong
 * @date 2013-1-7
 * 
 */
public class StatusServiceImpl implements StatusService {

	@Override
	public int insertStatus(StatusBean status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryCountByWid(String wid) {
		return 0;
	}

	@Override
	public List<StatusBean> queryStatuslistsByUid(String uid) {
		return statusDao.queryStatuslistsByUid(uid);
	}

	@Override
	public List<StatusBean> queryStatuslistsByMap(HashMap<String, Object> map) {
		return statusDao.queryStatuslistsByMap(map);
	}
	
	// 数据访问
	@Autowired
	private StatusDao statusDao;
}
