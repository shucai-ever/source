package com.dchip.cloudparking.wechat.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Stock generated by hbm2java
 */
@Entity
@Table(name = "stock", catalog = "cloud_parking")
public class Stock implements java.io.Serializable {

	private int id;
	private Integer parkCode;
	private int parkingId;
	private int totalCount;
	private Integer enterCount;
	private Date createTime;
	private Date updateTime;

	public Stock() {
	}

	public Stock(int id, int parkingId, int totalCount, Date createTime) {
		this.id = id;
		this.parkingId = parkingId;
		this.totalCount = totalCount;
		this.createTime = createTime;
	}

	public Stock(int id, Integer parkCode, int parkingId, int totalCount, Integer enterCount, Date createTime,
			Date updateTime) {
		this.id = id;
		this.parkCode = parkCode;
		this.parkingId = parkingId;
		this.totalCount = totalCount;
		this.enterCount = enterCount;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "park_code")
	public Integer getParkCode() {
		return this.parkCode;
	}

	public void setParkCode(Integer parkCode) {
		this.parkCode = parkCode;
	}

	@Column(name = "parking_id", nullable = false)
	public int getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	@Column(name = "total_count", nullable = false)
	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Column(name = "enter_count")
	public Integer getEnterCount() {
		return this.enterCount;
	}

	public void setEnterCount(Integer enterCount) {
		this.enterCount = enterCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
