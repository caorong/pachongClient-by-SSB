package com.cr.modules.weibo.dao;

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

}
