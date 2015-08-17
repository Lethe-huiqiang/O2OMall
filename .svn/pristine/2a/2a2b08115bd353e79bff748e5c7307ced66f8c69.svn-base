package com.jixie.bean;

import java.sql.Timestamp;

/**
 * RepairManagement entity. @author MyEclipse Persistence Tools
 */

public class RepairManagement implements java.io.Serializable {

	// Fields

	private String id;
	private String repairMemId;
	private Timestamp dispatchTime;
	private Integer acceptState;
	private Timestamp getTime;
	private Timestamp updateTime;
	private String comment;
	private Integer commentValue;

	// Constructors

	/** default constructor */
	public RepairManagement() {
	}

	/** minimal constructor */
	public RepairManagement(String repairMemId, Timestamp dispatchTime,
			Integer acceptState, Timestamp updateTime) {
		this.repairMemId = repairMemId;
		this.dispatchTime = dispatchTime;
		this.acceptState = acceptState;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public RepairManagement(String repairMemId, Timestamp dispatchTime,
			Integer acceptState, Timestamp getTime, Timestamp updateTime,
			String comment, Integer commentValue) {
		this.repairMemId = repairMemId;
		this.dispatchTime = dispatchTime;
		this.acceptState = acceptState;
		this.getTime = getTime;
		this.updateTime = updateTime;
		this.comment = comment;
		this.commentValue = commentValue;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepairMemId() {
		return this.repairMemId;
	}

	public void setRepairMemId(String repairMemId) {
		this.repairMemId = repairMemId;
	}

	public Timestamp getDispatchTime() {
		return this.dispatchTime;
	}

	public void setDispatchTime(Timestamp dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public Integer getAcceptState() {
		return this.acceptState;
	}

	public void setAcceptState(Integer acceptState) {
		this.acceptState = acceptState;
	}

	public Timestamp getGetTime() {
		return this.getTime;
	}

	public void setGetTime(Timestamp getTime) {
		this.getTime = getTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentValue() {
		return this.commentValue;
	}

	public void setCommentValue(Integer commentValue) {
		this.commentValue = commentValue;
	}

}