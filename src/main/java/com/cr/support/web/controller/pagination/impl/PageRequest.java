package com.cr.support.web.controller.pagination.impl;

import com.cr.support.web.controller.pagination.Pageable;

/**
 * @Description 分页实现-请求
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class PageRequest implements Pageable {
	
	public PageRequest(int start, int limit){
		this.start = start;
		this.limit = limit;
	}
	

	@Override
	public int getPageStart() {
		return start;
	}

	@Override
	public int getPageLimit() {
		return limit;
	}

	@Override
	public int getTotalPages() {
		//由pageResponse实现
		return -1;
	}
	
	@Override
	public <RESULTTYPE> RESULTTYPE getResult() {
		//由pageResponse实现
		return null;
	}

	//起始页
	private int start;
	//单页总量
	private int limit;
	
}
