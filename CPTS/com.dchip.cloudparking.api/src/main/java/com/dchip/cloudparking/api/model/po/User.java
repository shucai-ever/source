package com.dchip.cloudparking.api.model.po;
// Generated 2018-11-30 17:46:32 by Hibernate Tools 5.2.10.Final

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
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "cloud_parking")
public class User implements java.io.Serializable {

	private Integer id;
	private String openid;
	private byte[] nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private String privilege;
	private String unionid;
	private String phone;
	private String state;
	private String type;
	private Date createTime;
	private Integer falseReportNumber;
	private Date latestLoginTime;
	private String pwd;
	private String registrationId;
	private BigDecimal balance;
	private Integer grade;
	private Integer isBlack;
	private Integer memberId;
	private String drivingLicenseNumber;
	private String idCard;
	private String carOwnerName;
	private String driverLicenseNumber;
	private String licensePlat;
	private String authenticationFailReason;
	private Integer isAuthentication;

	public User() {
	}

	public User(String openid, byte[] nickname, String sex, String province, String city, String country,
			String headimgurl, String privilege, String unionid, String phone, String state, String type,
			Date createTime, Integer falseReportNumber, Date latestLoginTime, String pwd, String registrationId,
			BigDecimal balance, Integer grade, Integer isBlack, Integer memberId, String drivingLicenseNumber,
			String idCard, String carOwnerName, String driverLicenseNumber, String licensePlat,
			String authenticationFailReason, Integer isAuthentication) {
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.country = country;
		this.headimgurl = headimgurl;
		this.privilege = privilege;
		this.unionid = unionid;
		this.phone = phone;
		this.state = state;
		this.type = type;
		this.createTime = createTime;
		this.falseReportNumber = falseReportNumber;
		this.latestLoginTime = latestLoginTime;
		this.pwd = pwd;
		this.registrationId = registrationId;
		this.balance = balance;
		this.grade = grade;
		this.isBlack = isBlack;
		this.memberId = memberId;
		this.drivingLicenseNumber = drivingLicenseNumber;
		this.idCard = idCard;
		this.carOwnerName = carOwnerName;
		this.driverLicenseNumber = driverLicenseNumber;
		this.licensePlat = licensePlat;
		this.authenticationFailReason = authenticationFailReason;
		this.isAuthentication = isAuthentication;
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

	@Column(name = "openid", length = 200)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "nickname")
	public byte[] getNickname() {
		return this.nickname;
	}

	public void setNickname(byte[] nickname) {
		this.nickname = nickname;
	}

	@Column(name = "sex", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "province", length = 20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", length = 5)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "headimgurl", length = 65535)
	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	@Column(name = "privilege", length = 65535)
	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@Column(name = "unionid", length = 65535)
	public String getUnionid() {
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "state", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "type", length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "false_report_number")
	public Integer getFalseReportNumber() {
		return this.falseReportNumber;
	}

	public void setFalseReportNumber(Integer falseReportNumber) {
		this.falseReportNumber = falseReportNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "latest_login_time", length = 19)
	public Date getLatestLoginTime() {
		return this.latestLoginTime;
	}

	public void setLatestLoginTime(Date latestLoginTime) {
		this.latestLoginTime = latestLoginTime;
	}

	@Column(name = "pwd", length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "registration_id", length = 50)
	public String getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	@Column(name = "balance", precision = 20)
	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name = "grade")
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "is_black")
	public Integer getIsBlack() {
		return this.isBlack;
	}

	public void setIsBlack(Integer isBlack) {
		this.isBlack = isBlack;
	}

	@Column(name = "member_id")
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "driving_license_number", length = 50)
	public String getDrivingLicenseNumber() {
		return this.drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	@Column(name = "id_card", length = 50)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "car_owner_name", length = 50)
	public String getCarOwnerName() {
		return this.carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

	@Column(name = "driver_license_number", length = 50)
	public String getDriverLicenseNumber() {
		return this.driverLicenseNumber;
	}

	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}

	@Column(name = "license_plat", length = 20)
	public String getLicensePlat() {
		return this.licensePlat;
	}

	public void setLicensePlat(String licensePlat) {
		this.licensePlat = licensePlat;
	}

	@Column(name = "authentication_fail_reason")
	public String getAuthenticationFailReason() {
		return this.authenticationFailReason;
	}

	public void setAuthenticationFailReason(String authenticationFailReason) {
		this.authenticationFailReason = authenticationFailReason;
	}

	@Column(name = "is_authentication")
	public Integer getIsAuthentication() {
		return this.isAuthentication;
	}

	public void setIsAuthentication(Integer isAuthentication) {
		this.isAuthentication = isAuthentication;
	}

}
