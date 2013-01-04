package com.cr.modules.sample.dao;

import java.util.List;

import com.cr.modules.sample.model.SampleReg;
import com.cr.support.repository.mybatis._annotation.MyBatisRepository;

/**
 * @Description 样例数据访问接口
 * @author caobin
 * @date 2012-11-16
 * @version 1.0
 */
@MyBatisRepository
public interface SampleDao {

	/**
	 * @Description 插入新记录
	 * @param sampleReg
	 * @author caobin
	 */
	void insert(SampleReg sampleReg);
	
	
	/**
	 * @Description 查询所有记录
	 * @return
	 * @author caobin
	 */
	List<SampleReg> queryAll();
	
	/**
	 * @Description 查询指定id的记录
	 * @param id
	 * @return
	 * @author caobin
	 */
	List<SampleReg> query(SampleReg sampleReg);
	
	/**
	 * @Description 更新记录
	 * @param sampleReg
	 * @author caobin
	 */
	void update(SampleReg sampleReg);
	
	/**
	 * @Description 通过id删除记录
	 * @param id
	 * @author caobin
	 */
	void delete(String id);
}
