/**
 * 
 */
package com.cr.modules.weibo.dao;

import java.util.List;

import com.cr.modules.weibo.model.RelationPathBean;
import com.cr.support.repository.mybatis._annotation.MyBatisRepository;



/**
 * @Description	
 * @author caorong
 * @date 2013-1-6
 * 
 */
@MyBatisRepository
public interface RelationPathDao {
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
	 * @Description 取相关RelationPathBeanByCenterUid
	 * @param relationPathBean
	 * @return
	 * @author caorong
	 */
	public List<RelationPathBean> queryRelationPathsByCenterUid(String Centeruid);
}
