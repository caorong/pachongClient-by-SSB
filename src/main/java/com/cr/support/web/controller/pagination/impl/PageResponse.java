package com.cr.support.web.controller.pagination.impl;

import com.cr.support.web.controller.pagination.Pageable;

/**
 * @Description 分页实现-响应
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class PageResponse<RESULTTYPE> implements Pageable {
	
	public PageResponse(RESULTTYPE result, int totalPages){
		this.result = result;
		this.totalPages = totalPages;
	}

	@Override
	public int getPageStart() {
		//由PageRequest实现
		return -1;
	}

	@Override
	public int getPageLimit() {
		//由PageRequest实现
		return -1;
	}

	@Override
	public int getTotalPages() {
		return totalPages;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RESULTTYPE getResult() {
		return result;
	}
	
	//结果集
	private RESULTTYPE result;
	//总页数
	private int totalPages;
}
