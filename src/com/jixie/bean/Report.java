package com.jixie.bean;

import java.sql.Timestamp;

/**
 * Report entity. @author MyEclipse Persistence Tools
 */

public class Report implements java.io.Serializable {

	// Fields

	private String id;
	private String reporterId;
	private String reportedId;
	private String reportReason;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Report() {
	}

	/** full constructor */
	public Report(String id, String reporterId, String reportedId,
			String reportReason, Timestamp createTime) {
		this.id = id;
		this.reporterId = reporterId;
		this.reportedId = reportedId;
		this.reportReason = reportReason;
		this.createTime = createTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReporterId() {
		return this.reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public String getReportedId() {
		return this.reportedId;
	}

	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}

	public String getReportReason() {
		return this.reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}