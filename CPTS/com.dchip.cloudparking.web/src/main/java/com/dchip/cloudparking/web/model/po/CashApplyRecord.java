package com.dchip.cloudparking.web.model.po;
// Generated 2019-1-21 10:51:34 by Hibernate Tools 5.2.10.Final

import java.math.BigDecimal;
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
 * CashApplyRecord generated by hbm2java
 */
@Entity
@Table(name = "cash_apply_record", catalog = "cloud_parking")
public class CashApplyRecord implements java.io.Serializable {

	private Integer id;
	private int companyId;
	private String orderIds;
	private Date createTime;
	private Integer applyStatus;
	private String remark;
	private Date handleTime;
	private Integer moneyStatus;
	private BigDecimal free;

	public CashApplyRecord() {
	}

	public CashApplyRecord(int companyId, String orderIds, Date createTime, BigDecimal free) {
		this.companyId = companyId;
		this.orderIds = orderIds;
		this.createTime = createTime;
		this.free = free;
	}

	public CashApplyRecord(int companyId, String orderIds, Date createTime, Integer applyStatus, String remark,
			Date handleTime, Integer moneyStatus, BigDecimal free) {
		this.companyId = companyId;
		this.orderIds = orderIds;
		this.createTime = createTime;
		this.applyStatus = applyStatus;
		this.remark = remark;
		this.handleTime = handleTime;
		this.moneyStatus = moneyStatus;
		this.free = free;
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

	@Column(name = "company_id", nullable = false)
	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "order_ids", nullable = false)
	public String getOrderIds() {
		return this.orderIds;
	}

	public void setOrderIds(String orderIds) {
		this.orderIds = orderIds;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "apply_status")
	public Integer getApplyStatus() {
		return this.applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "handle_time", length = 19)
	public Date getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	@Column(name = "money_status")
	public Integer getMoneyStatus() {
		return this.moneyStatus;
	}

	public void setMoneyStatus(Integer moneyStatus) {
		this.moneyStatus = moneyStatus;
	}

	@Column(name = "free", nullable = false, precision = 11)
	public BigDecimal getFree() {
		return this.free;
	}

	public void setFree(BigDecimal free) {
		this.free = free;
	}

}
