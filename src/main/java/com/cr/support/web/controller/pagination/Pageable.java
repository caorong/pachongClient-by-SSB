package com.cr.support.web.controller.pagination;

/**
 * @Description 分页接口 
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public interface Pageable {

	/**
	 * @Description 获取起始页索引
	 * @return
	 * @author caobin
	 */
	int getPageStart();

	/**
	 * @Description 获取单页显示总量
	 * @return
	 * @author caobin
	 */
	int getPageLimit();

	/**
	 * @Description 获取总页数
	 * @return
	 * @author caobin
	 */
	int getTotalPages();

	/**
	 * @Description 获取结果集
	 * @return
	 * @author caobin
	 */
	<RESULTTYPE> RESULTTYPE getResult();

}
