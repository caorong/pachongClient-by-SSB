/**
 * 
 */
package com.cr.modules.weibo.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Description  树形返回结构
 * @author caorong
 * @date 2013-1-8
 * 
 */
public class ReStatDeepPosBean implements Serializable {

	private static final long serialVersionUID = -1034138058099793291L;

	private String id;
	private String name;
	private String size;
	private String parentid;

	public ReStatDeepPosBean() {
		// TODO Auto-generated constructor stub
	}
	public ReStatDeepPosBean(String id,String name,String size,String parentid) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.parentid = parentid;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
