package com.dchip.cloudparking.web.model.po;
// Generated 2018-11-1 11:18:16 by Hibernate Tools 5.2.10.Final

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
 * PointRecord generated by hbm2java
 */
@Entity
@Table(name = "point_record", catalog = "cloud_parking")
public class PointRecord implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private Integer score;
	private String remark;
	private Date createTime;

	public PointRecord() {
	}

	public PointRecord(Integer userId, Integer score, String remark, Date createTime) {
		this.userId = userId;
		this.score = score;
		this.remark = remark;
		this.createTime = createTime;
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

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
