package com.dchip.cloudparking.wechat.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FreeModel generated by hbm2java
 */
@Entity
@Table(name = "free_model", catalog = "cloud_parking")
public class FreeModel implements java.io.Serializable {

	private Integer id;
	private String freeModelName;
	private Integer freeTimeLength;
	private BigDecimal hourCost;
	private BigDecimal mostCost;

	public FreeModel() {
	}

	public FreeModel(String freeModelName, Integer freeTimeLength, BigDecimal hourCost, BigDecimal mostCost) {
		this.freeModelName = freeModelName;
		this.freeTimeLength = freeTimeLength;
		this.hourCost = hourCost;
		this.mostCost = mostCost;
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

	@Column(name = "free_model_name", length = 50)
	public String getFreeModelName() {
		return this.freeModelName;
	}

	public void setFreeModelName(String freeModelName) {
		this.freeModelName = freeModelName;
	}

	@Column(name = "free_time_length")
	public Integer getFreeTimeLength() {
		return this.freeTimeLength;
	}

	public void setFreeTimeLength(Integer freeTimeLength) {
		this.freeTimeLength = freeTimeLength;
	}

	@Column(name = "hour_cost", precision = 10)
	public BigDecimal getHourCost() {
		return this.hourCost;
	}

	public void setHourCost(BigDecimal hourCost) {
		this.hourCost = hourCost;
	}

	@Column(name = "most_cost", precision = 10)
	public BigDecimal getMostCost() {
		return this.mostCost;
	}

	public void setMostCost(BigDecimal mostCost) {
		this.mostCost = mostCost;
	}

}
