package com.cr.modules.weibo.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Description 绘制用户关系图的model
 * @author caorong
 * @date 2013-1-5
 * 
 */
public class RelationPathBean implements Serializable {

	private static final long serialVersionUID = -6305918582607920900L;

	// 用于给数据库表示
	private String Centeruid;
	private String uid;
	private String x;
	private String y;
	private String name;

	public RelationPathBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param CenterUid
	 * @param uid
	 * @param x
	 * @param y
	 * @param name
	 * */
	public RelationPathBean(String centeruid, String uid, String x, String y,
			String name) {
		this.Centeruid = centeruid;
		this.uid = uid;
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public String getCenteruid() {
		return Centeruid;
	}

	public void setCenteruid(String centeruid) {
		Centeruid = centeruid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
