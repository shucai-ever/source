package com.dchip.cloudparking.wechat.model.po;
// Generated 2018-12-7 10:40:29 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Coupon generated by hbm2java
 */
@Entity
@Table(name = "coupon", catalog = "cloud_parking")
public class Coupon implements java.io.Serializable {

	private Integer id;
	private String remark;
	private Integer count;
	private Integer status;
	private String memberIds;
	private Integer endNum;
	private Integer endType;
	private Date endTime;
	private Integer deductionType;
	private Integer partDeduction;
	private Date createTime;

	public Coupon() {
	}

	public Coupon(String remark, Integer count, Integer status, String memberIds, Integer endNum, Integer endType,
			Date endTime, Integer deductionType, Integer partDeduction, Date createTime) {
		this.remark = remark;
		this.count = count;
		this.status = status;
		this.memberIds = memberIds;
		this.endNum = endNum;
		this.endType = endType;
		this.endTime = endTime;
		this.deductionType = deductionType;
		this.partDeduction = partDeduction;
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

	@Lob
	@Column(name = "remark", length = 254 , columnDefinition="TEXT")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "member_ids", length = 65535)
	public String getMemberIds() {
		return this.memberIds;
	}

	public void setMemberIds(String memberIds) {
		this.memberIds = memberIds;
	}

	@Column(name = "end_num")
	public Integer getEndNum() {
		return this.endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	@Column(name = "end_type")
	public Integer getEndType() {
		return this.endType;
	}

	public void setEndType(Integer endType) {
		this.endType = endType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "deduction_type")
	public Integer getDeductionType() {
		return this.deductionType;
	}

	public void setDeductionType(Integer deductionType) {
		this.deductionType = deductionType;
	}

	@Column(name = "part_deduction")
	public Integer getPartDeduction() {
		return this.partDeduction;
	}

	public void setPartDeduction(Integer partDeduction) {
		this.partDeduction = partDeduction;
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
