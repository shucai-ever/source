package com.dchip.cloudparking.web.model.po;
// Generated 2018-12-11 14:57:46 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Activity generated by hbm2java
 */
@Entity
@Table(name = "activity", catalog = "cloud_parking")
public class Activity implements java.io.Serializable {

	private Integer id;
	private String remark;
	private int effectiveType;
	private Date effectiveTime;
	private Integer couponId;
	private Date createTime;
	private Integer status;
	/**
	 * 发放数量
	 */
	private Integer couponCount;

	public Activity() {
	}

	public Activity(int effectiveType) {
		this.effectiveType = effectiveType;
	}

	public Activity(Integer id, String remark, int effectiveType, Date effectiveTime, Integer couponId, Date createTime, Integer status, Integer couponCount) {
		this.id = id;
		this.remark = remark;
		this.effectiveType = effectiveType;
		this.effectiveTime = effectiveTime;
		this.couponId = couponId;
		this.createTime = createTime;
		this.status = status;
		this.couponCount = couponCount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "effective_type", nullable = false)
	public int getEffectiveType() {
		return this.effectiveType;
	}

	public void setEffectiveType(int effectiveType) {
		this.effectiveType = effectiveType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_time", length = 19)
	public Date getEffectiveTime() {
		return this.effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	@Column(name = "coupon_id")
	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "`create_time`", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "`status`", length = 2)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "`coupon_count`")
	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}
}
