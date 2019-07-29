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
 * Finance generated by hbm2java
 */
@Entity
@Table(name = "finance", catalog = "cloud_parking")
public class Finance implements java.io.Serializable {

	private Integer id;
	private Integer companyId;
	private String orderId;
	private Date chargeTime;
	private Integer status;
	private Date createTime;
	private Integer payPlatform;
	private Double totalAmount;
	private Double payMoney;
	private Date payTime;
	private String remark;
	private String calculateAccount;
	private String calculateName;
	private String calculatePerson;
	private Integer companyBalcanceWayId;
	private Integer parkingId;
	private Integer type;

	public Finance() {
	}

	public Finance(String calculateAccount, String calculateName, String calculatePerson) {
		this.calculateAccount = calculateAccount;
		this.calculateName = calculateName;
		this.calculatePerson = calculatePerson;
	}

	public Finance(Integer companyId, String orderId, Date chargeTime, Integer status, Date createTime,
			Integer payPlatform, Double totalAmount, Double payMoney, Date payTime, String remark,
			String calculateAccount, String calculateName, String calculatePerson, Integer companyBalcanceWayId,
			Integer parkingId, Integer type) {
		this.companyId = companyId;
		this.orderId = orderId;
		this.chargeTime = chargeTime;
		this.status = status;
		this.createTime = createTime;
		this.payPlatform = payPlatform;
		this.totalAmount = totalAmount;
		this.payMoney = payMoney;
		this.payTime = payTime;
		this.remark = remark;
		this.calculateAccount = calculateAccount;
		this.calculateName = calculateName;
		this.calculatePerson = calculatePerson;
		this.companyBalcanceWayId = companyBalcanceWayId;
		this.parkingId = parkingId;
		this.type = type;
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

	@Column(name = "company_id")
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "order_id", length = 50)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "charge_time", length = 10)
	public Date getChargeTime() {
		return this.chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
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

	@Column(name = "pay_platform")
	public Integer getPayPlatform() {
		return this.payPlatform;
	}

	public void setPayPlatform(Integer payPlatform) {
		this.payPlatform = payPlatform;
	}

	@Column(name = "total_amount", precision = 11)
	public Double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "pay_money", precision = 11)
	public Double getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_time", length = 19)
	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "calculate_account", nullable = false, length = 50)
	public String getCalculateAccount() {
		return this.calculateAccount;
	}

	public void setCalculateAccount(String calculateAccount) {
		this.calculateAccount = calculateAccount;
	}

	@Column(name = "calculate_name", nullable = false, length = 50)
	public String getCalculateName() {
		return this.calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	@Column(name = "calculate_person", nullable = false, length = 50)
	public String getCalculatePerson() {
		return this.calculatePerson;
	}

	public void setCalculatePerson(String calculatePerson) {
		this.calculatePerson = calculatePerson;
	}

	@Column(name = "company_balcance_way_id")
	public Integer getCompanyBalcanceWayId() {
		return this.companyBalcanceWayId;
	}

	public void setCompanyBalcanceWayId(Integer companyBalcanceWayId) {
		this.companyBalcanceWayId = companyBalcanceWayId;
	}

	@Column(name = "parking_id")
	public Integer getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
