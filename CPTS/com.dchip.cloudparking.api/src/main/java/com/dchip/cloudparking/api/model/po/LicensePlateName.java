package com.dchip.cloudparking.api.model.po;
// Generated 2019-1-1 0:11:39 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LicensePlateName generated by hbm2java
 */
@Entity
@Table(name = "license_plate_name", catalog = "cloud_parking")
public class LicensePlateName implements java.io.Serializable {

	private Integer id;
	private String licensePlateName;
	private Integer typeNumber;
	private Integer type;

	public LicensePlateName() {
	}

	public LicensePlateName(String licensePlateName, Integer typeNumber, Integer type) {
		this.licensePlateName = licensePlateName;
		this.typeNumber = typeNumber;
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

	@Column(name = "license_plate_name", length = 20)
	public String getLicensePlateName() {
		return this.licensePlateName;
	}

	public void setLicensePlateName(String licensePlateName) {
		this.licensePlateName = licensePlateName;
	}

	@Column(name = "type_number")
	public Integer getTypeNumber() {
		return this.typeNumber;
	}

	public void setTypeNumber(Integer typeNumber) {
		this.typeNumber = typeNumber;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
