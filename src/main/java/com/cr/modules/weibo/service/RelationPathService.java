/**
 * 
 */
package com.cr.modules.weibo.service;

import java.util.List;

import com.cr.modules.weibo.model.RelationPathBean;

/**
 * @Description	RelationPath
 * @author caorong
 * @date 2013-1-6
 * 
 */
public interface RelationPathService {

	/**
	 * @Description 添加path
	 * @param relationPathBean
	 * @return
	 * @author caorong
	 */
	public int insertRelationPathBean(RelationPathBean relationPathBean);
	
	/**
	 * @Description 查询重复path
	 * @param relationPathBean
	 * @return
	 * @author caorong
	 */
	public int queryRelationPathBeanByBean(RelationPathBean relationPathBean);
	
	/**
	 * @Description 查询重复path
	 * @param relationPathBean
	 * @return
	 * @author caorong
	 */
	public List<RelationPathBean> queryRelationPathsByCenterUid(String Centeruid);
}
