package com.dchip.cloudparking.api.model.po;
// Generated 2018-12-10 20:45:18 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roadway generated by hbm2java
 */
@Entity
@Table(name = "roadway", catalog = "cloud_parking")
public class Roadway implements java.io.Serializable {

	private int id;
	private String address;
	private String cameraIp;
	private Integer cameraType;
	private Integer communication;
	private Integer gateNumber;
	private Integer inOutMarker;
	private String ledIp;
	private String ledModel;
	private Integer ledScreenRowNum;
	private Integer parkingId;
	private String roadName;
	private String roadSign;
	private Integer showWay;
	private Integer voiceLed;
	private String cameraMac;
	private Integer status;
	private Integer isOnline;

	public Roadway() {
	}

	public Roadway(int id) {
		this.id = id;
	}

	public Roadway(int id, String address, String cameraIp, Integer cameraType, Integer communication,
			Integer gateNumber, Integer inOutMarker, String ledIp, String ledModel, Integer ledScreenRowNum,
			Integer parkingId, String roadName, String roadSign, Integer showWay, Integer voiceLed, String cameraMac,
			Integer status, Integer isOnline) {
		this.id = id;
		this.address = address;
		this.cameraIp = cameraIp;
		this.cameraType = cameraType;
		this.communication = communication;
		this.gateNumber = gateNumber;
		this.inOutMarker = inOutMarker;
		this.ledIp = ledIp;
		this.ledModel = ledModel;
		this.ledScreenRowNum = ledScreenRowNum;
		this.parkingId = parkingId;
		this.roadName = roadName;
		this.roadSign = roadSign;
		this.showWay = showWay;
		this.voiceLed = voiceLed;
		this.cameraMac = cameraMac;
		this.status = status;
		this.isOnline = isOnline;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "camera_ip", length = 50)
	public String getCameraIp() {
		return this.cameraIp;
	}

	public void setCameraIp(String cameraIp) {
		this.cameraIp = cameraIp;
	}

	@Column(name = "camera_type")
	public Integer getCameraType() {
		return this.cameraType;
	}

	public void setCameraType(Integer cameraType) {
		this.cameraType = cameraType;
	}

	@Column(name = "communication")
	public Integer getCommunication() {
		return this.communication;
	}

	public void setCommunication(Integer communication) {
		this.communication = communication;
	}

	@Column(name = "gate_number")
	public Integer getGateNumber() {
		return this.gateNumber;
	}

	public void setGateNumber(Integer gateNumber) {
		this.gateNumber = gateNumber;
	}

	@Column(name = "in_out_marker")
	public Integer getInOutMarker() {
		return this.inOutMarker;
	}

	public void setInOutMarker(Integer inOutMarker) {
		this.inOutMarker = inOutMarker;
	}

	@Column(name = "led_ip", length = 50)
	public String getLedIp() {
		return this.ledIp;
	}

	public void setLedIp(String ledIp) {
		this.ledIp = ledIp;
	}

	@Column(name = "led_model", length = 50)
	public String getLedModel() {
		return this.ledModel;
	}

	public void setLedModel(String ledModel) {
		this.ledModel = ledModel;
	}

	@Column(name = "led_screen_row_num")
	public Integer getLedScreenRowNum() {
		return this.ledScreenRowNum;
	}

	public void setLedScreenRowNum(Integer ledScreenRowNum) {
		this.ledScreenRowNum = ledScreenRowNum;
	}

	@Column(name = "parking_id")
	public Integer getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	@Column(name = "road_name", length = 50)
	public String getRoadName() {
		return this.roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	@Column(name = "road_sign", length = 50)
	public String getRoadSign() {
		return this.roadSign;
	}

	public void setRoadSign(String roadSign) {
		this.roadSign = roadSign;
	}

	@Column(name = "show_way")
	public Integer getShowWay() {
		return this.showWay;
	}

	public void setShowWay(Integer showWay) {
		this.showWay = showWay;
	}

	@Column(name = "voice_led")
	public Integer getVoiceLed() {
		return this.voiceLed;
	}

	public void setVoiceLed(Integer voiceLed) {
		this.voiceLed = voiceLed;
	}

	@Column(name = "camera_mac", length = 50)
	public String getCameraMac() {
		return this.cameraMac;
	}

	public void setCameraMac(String cameraMac) {
		this.cameraMac = cameraMac;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "is_online")
	public Integer getIsOnline() {
		return this.isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

}
