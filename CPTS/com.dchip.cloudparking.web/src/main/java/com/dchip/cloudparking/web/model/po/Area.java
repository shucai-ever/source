package com.dchip.cloudparking.web.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Area generated by hbm2java
 */
@Entity
@Table(name = "area", catalog = "cloud_parking")
public class Area implements java.io.Serializable {

	private Integer id;
	private Integer parkCode;
	private int areaCode;
	private String areaName;
	private Integer parkingId;
	private String longitude;
	private String latitude;
	private Integer spaceCount;

	public Area() {
	}

	public Area(int areaCode, String areaName) {
		this.areaCode = areaCode;
		this.areaName = areaName;
	}

	public Area(Integer parkCode, int areaCode, String areaName, Integer parkingId, String longitude, String latitude,
			Integer spaceCount) {
		this.parkCode = parkCode;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.parkingId = parkingId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.spaceCount = spaceCount;
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

	@Column(name = "park_code")
	public Integer getParkCode() {
		return this.parkCode;
	}

	public void setParkCode(Integer parkCode) {
		this.parkCode = parkCode;
	}

	@Column(name = "area_code", nullable = false)
	public int getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "area_name", nullable = false, length = 10)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "parking_id")
	public Integer getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	@Column(name = "longitude", length = 50)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", length = 50)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "space_count")
	public Integer getSpaceCount() {
		return this.spaceCount;
	}

	public void setSpaceCount(Integer spaceCount) {
		this.spaceCount = spaceCount;
	}

}
