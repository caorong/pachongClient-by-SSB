package com.cr.modules.sample.service;

import java.util.List;

import com.cr.modules.sample.model.SampleReg;


/**
 * @Description 样例Service层接口
 * @author caobin
 * @date 2012-11-16
 * @version 1.0
 */
public interface SampleService {

	/**
	 * @Description 创建样例注册信息
	 * @param sampleReg 样例注册信息model实例
	 * @author caobin
	 */
	void create(SampleReg sampleReg);
	
	/**
	 * @Description 查询所有样例注册信息
	 * @return
	 * @author caobin
	 */
	List<SampleReg> queryAll();
	
	
	/**
	 * @Description 查询指定样例注册信息
	 * @param id
	 * @return
	 * @author caobin
	 */
	List<SampleReg> query(SampleReg sampleReg);
	
	/**
	 * @Description 更新样例注册信息
	 * @param sampleReg
	 * @author caobin
	 */
	void update(SampleReg sampleReg);
	
	/**
	 * @Description 删除指定样例注册程序
	 * @param id
	 * @author caobin
	 */
	void delete(String id);
	
	/**
	 * @Description 发送样例注册信息消息
	 * @param sampleReg
	 * @author caobin
	 */
	void sendRegMessage(SampleReg sampleReg);
}
