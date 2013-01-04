package com.cr.modules.sample.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cr.modules.sample.dao.SampleDao;
import com.cr.modules.sample.model.SampleReg;
import com.cr.modules.sample.remote.SampleRemote;
import com.cr.modules.sample.service.SampleService;
import com.cr.support.exception.PSFPRuntimeSystemException;
import com.cr.support.util.MessageUtils;



/**
 * @Description 样例Service
 * @author caobin
 * @date 2012-11-16
 * @version 1.0
 */
@Transactional(readOnly=true)
public class SampleServiceImpl implements SampleService {

	// 此处使用注解事务来保证事务的ACID
	// MyBatis的事务通过默认传播级别会加入spring的事务并受到spring容器的管理
	@Transactional(readOnly=false)
	@Override
	public void create(SampleReg sampleReg) {
		sampleDao.insert(sampleReg);
	}

	@Override
	public List<SampleReg> queryAll() {
		return sampleDao.queryAll();
	}

	@Override
	public List<SampleReg> query(SampleReg sampleReg) {
		return sampleDao.query(sampleReg);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(SampleReg sampleReg) {
		sampleDao.update(sampleReg);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(String id) {
		sampleDao.delete(id);
	}
	
	@Override
	public void sendRegMessage(SampleReg sampleReg) {
		try {
			String xmlMessage = MessageUtils.toXml(sampleReg);
			log.debug("XML MESSAGE: {}", new Object[]{xmlMessage});
			sampleRemote.sendSamplRegMessage(xmlMessage);
			log.debug("message sent.");
		} catch (UnsupportedEncodingException e) {
			throw new PSFPRuntimeSystemException(e.getMessage());
		}	
	}


	// 数据访问
	@Autowired
	private SampleDao sampleDao;
	// 远程服务
	@Autowired
	private SampleRemote sampleRemote;
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
}
