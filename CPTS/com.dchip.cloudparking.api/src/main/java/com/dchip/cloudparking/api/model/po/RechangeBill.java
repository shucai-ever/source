package com.dchip.cloudparking.api.model.po;
// Generated 2018-11-30 17:46:32 by Hibernate Tools 5.2.10.Final

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
 * RechangeBill generated by hbm2java
 */
@Entity
@Table(name = "rechange_bill", catalog = "cloud_parking")
public class RechangeBill implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private String orderId;
	private Integer type;
	private Integer payPlatform;
	private Integer status;
	private Date createTime;
	private Double amount;

	public RechangeBill() {
	}

	public RechangeBill(Integer userId, String orderId, Integer type, Integer payPlatform, Integer status,
			Date createTime, Double amount) {
		this.userId = userId;
		this.orderId = orderId;
		this.type = type;
		this.payPlatform = payPlatform;
		this.status = status;
		this.createTime = createTime;
		this.amount = amount;
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

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "order_id", length = 100)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "pay_platform")
	public Integer getPayPlatform() {
		return this.payPlatform;
	}

	public void setPayPlatform(Integer payPlatform) {
		this.payPlatform = payPlatform;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "amount", precision = 11)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
