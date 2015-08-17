package com.jixie.bean;

import java.sql.Timestamp;

/**
 * MemberAchievement entity. @author MyEclipse Persistence Tools
 */

public class MemberAchievement implements java.io.Serializable {

	// Fields

	private String id;
	private Integer acceptCount;
	private Integer achieveCount;
	private Integer refuseCount;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public MemberAchievement() {
	}

	/** full constructor */
	public MemberAchievement(Integer acceptCount, Integer achieveCount,
			Integer refuseCount, Timestamp updateTime) {
		this.acceptCount = acceptCount;
		this.achieveCount = achieveCount;
		this.refuseCount = refuseCount;
		this.updateTime = updateTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAcceptCount() {
		return this.acceptCount;
	}

	public void setAcceptCount(Integer acceptCount) {
		this.acceptCount = acceptCount;
	}

	public Integer getAchieveCount() {
		return this.achieveCount;
	}

	public void setAchieveCount(Integer achieveCount) {
		this.achieveCount = achieveCount;
	}

	public Integer getRefuseCount() {
		return this.refuseCount;
	}

	public void setRefuseCount(Integer refuseCount) {
		this.refuseCount = refuseCount;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}