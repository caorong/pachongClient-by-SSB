/**
 * 
 */
package com.cr.modules.weibo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cr.modules.weibo.dao.RelationPathDao;
import com.cr.modules.weibo.model.RelationPathBean;
import com.cr.modules.weibo.service.RelationPathService;

/**
 * @Description	
 * @author caorong
 * @date 2013-1-6
 * 
 */
@Transactional(readOnly=true)
public class RelationPathServiceImpl implements RelationPathService {

	@Override
	public int insertRelationPathBean(RelationPathBean relationPathBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cr.modules.weibo.service.RelationPathService#queryRelationPathBeanByBean(com.cr.modules.weibo.model.RelationPathBean)
	 */
	@Override
	public int queryRelationPathBeanByBean(RelationPathBean relationPathBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RelationPathBean> queryRelationPathsByCenterUid(String Centeruid) {
		return relationPathDao.queryRelationPathsByCenterUid(Centeruid);
	}

	// 数据访问
	@Autowired
	private RelationPathDao relationPathDao;
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
}
