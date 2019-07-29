package com.dchip.cloudparking.web.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserLicensePlat generated by hbm2java
 */
@Entity
@Table(name = "user_license_plat", catalog = "cloud_parking")
public class UserLicensePlat implements java.io.Serializable {

	private int id;
	private Integer userId;
	private String licensePlat;
	private Date bindTime;
	private String carOwnerName;
	private String drivingLicenseNumber;

	public UserLicensePlat() {
	}

	public UserLicensePlat(int id) {
		this.id = id;
	}

	public UserLicensePlat(int id, Integer userId, String licensePlat, Date bindTime, String carOwnerName,
			String drivingLicenseNumber) {
		this.id = id;
		this.userId = userId;
		this.licensePlat = licensePlat;
		this.bindTime = bindTime;
		this.carOwnerName = carOwnerName;
		this.drivingLicenseNumber = drivingLicenseNumber;
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

	@Column(name = "license_plat", length = 20)
	public String getLicensePlat() {
		return this.licensePlat;
	}

	public void setLicensePlat(String licensePlat) {
		this.licensePlat = licensePlat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bind_time", length = 19)
	public Date getBindTime() {
		return this.bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	@Column(name = "car_owner_name", length = 50)
	public String getCarOwnerName() {
		return this.carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

	@Column(name = "driving_license_number", length = 100)
	public String getDrivingLicenseNumber() {
		return this.drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

}