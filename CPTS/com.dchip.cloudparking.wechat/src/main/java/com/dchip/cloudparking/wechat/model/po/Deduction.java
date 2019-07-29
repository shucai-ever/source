package com.dchip.cloudparking.wechat.model.po;
// Generated 2019-1-4 9:34:13 by Hibernate Tools 5.2.10.Final

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
 * Deduction generated by hbm2java
 */
@Entity
@Table(name = "deduction", catalog = "cloud_parking")
public class Deduction implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private int parkingId;
	private Integer hourNum;
	private int status;
	private Date dueTime;
	private String licensePlat;
	private Date receiveTime;//领用时间
	private Date useTime;//使用时间
	private String deductioinCode;
	private String consumptionUrl;
	private Integer parkingUserId;
	private Integer deductionModelId;

	public Deduction() {
	}

	public Deduction(int parkingId, int status) {
		this.parkingId = parkingId;
		this.status = status;
	}

	public Deduction(int parkingId, Integer hourNum, int status, Date dueTime, String licensePlat, Date useTime,
			Date receiveTime, String deductioinCode, String consumptionUrl, Integer parkingUserId,
			Integer deductionModelId) {
		this.parkingId = parkingId;
		this.hourNum = hourNum;
		this.status = status;
		this.dueTime = dueTime;
		this.licensePlat = licensePlat;
		this.useTime = useTime;
		this.receiveTime = receiveTime;
		this.deductioinCode = deductioinCode;
		this.consumptionUrl = consumptionUrl;
		this.parkingUserId = parkingUserId;
		this.deductionModelId = deductionModelId;
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

	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "parking_id", nullable = false)
	public int getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	@Column(name = "hour_num")
	public Integer getHourNum() {
		return this.hourNum;
	}

	public void setHourNum(Integer hourNum) {
		this.hourNum = hourNum;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "due_time", length = 19)
	public Date getDueTime() {
		return this.dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	@Column(name = "license_plat", length = 20)
	public String getLicensePlat() {
		return this.licensePlat;
	}

	public void setLicensePlat(String licensePlat) {
		this.licensePlat = licensePlat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "use_time", length = 19)
	public Date getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receive_time", length = 19)
	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Column(name = "deductioin_code", length = 100)
	public String getDeductioinCode() {
		return this.deductioinCode;
	}

	public void setDeductioinCode(String deductioinCode) {
		this.deductioinCode = deductioinCode;
	}

	@Column(name = "consumption_url", length = 100)
	public String getConsumptionUrl() {
		return this.consumptionUrl;
	}

	public void setConsumptionUrl(String consumptionUrl) {
		this.consumptionUrl = consumptionUrl;
	}

	@Column(name = "parking_user_id")
	public Integer getParkingUserId() {
		return this.parkingUserId;
	}

	public void setParkingUserId(Integer parkingUserId) {
		this.parkingUserId = parkingUserId;
	}

	@Column(name = "deduction_model_id")
	public Integer getDeductionModelId() {
		return this.deductionModelId;
	}

	public void setDeductionModelId(Integer deductionModelId) {
		this.deductionModelId = deductionModelId;
	}

}
