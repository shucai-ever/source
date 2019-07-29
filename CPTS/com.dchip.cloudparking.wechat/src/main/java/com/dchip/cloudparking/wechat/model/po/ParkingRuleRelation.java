package com.dchip.cloudparking.wechat.model.po;
// Generated 2018-12-5 15:09:24 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ParkingRuleRelation generated by hbm2java
 */
@Entity
@Table(name = "parking_rule_relation", catalog = "cloud_parking")
public class ParkingRuleRelation implements java.io.Serializable {

	private Integer id;
	private Integer parkingRuleId;
	private Integer parkingId;

	public ParkingRuleRelation() {
	}

	public ParkingRuleRelation(Integer parkingRuleId, Integer parkingId) {
		this.parkingRuleId = parkingRuleId;
		this.parkingId = parkingId;
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

	@Column(name = "parking_rule_id", nullable = false)
	public Integer getParkingRuleId() {
		return this.parkingRuleId;
	}

	public void setParkingRuleId(Integer parkingRuleId) {
		this.parkingRuleId = parkingRuleId;
	}

	@Column(name = "parking_id", nullable = false)
	public Integer getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

}
