package com.dchip.cloudparking.wechat.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserThrid generated by hbm2java
 */
@Entity
@Table(name = "user_thrid", catalog = "cloud_parking")
public class UserThrid implements java.io.Serializable {

	private int id;
	private Integer userId;
	private Integer flag;
	private String openId;

	public UserThrid() {
	}

	public UserThrid(int id, String openId) {
		this.id = id;
		this.openId = openId;
	}

	public UserThrid(int id, Integer userId, Integer flag, String openId) {
		this.id = id;
		this.userId = userId;
		this.flag = flag;
		this.openId = openId;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "open_id", nullable = false, length = 100)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
