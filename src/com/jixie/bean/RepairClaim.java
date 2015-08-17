package com.jixie.bean;

import java.sql.Timestamp;

/**
 * RepairClaim entity. @author MyEclipse Persistence Tools
 */

public class RepairClaim implements java.io.Serializable {

	// Fields

	private String id;
	private String macOwnerId;
	private Integer state;
	private String macOwner;
	private String longTel;
	private String shortTel;
	private String address;
	private String machine;
	private String system;
	private Integer storage;
	private String description;
	private Timestamp creTime;
	private boolean isComment;
	
	/*public String toJson(){
		String json = "{'id':'" + id + "'," + "'state':'" + state +"'," + "'macOwner':'" + macOwner + "'," + "'longTel':'"+ longTel + "'," + 
						"'shortTel':'" + shortTel +",'" +"'address':'" + address + "'," + "'machine':'" + machine +"'," +
						"'system':'" + system + "'," + "'storage':'" + storage + "'," + "'description':'" + description + "'，" + "'creTime':'" + creTime + "'}";
		return json;
	}*/
	// Constructors

	/** default constructor */
	public RepairClaim() {
	}

	/** minimal constructor */
	public RepairClaim(Integer state, String macOwner, String longTel,
			String address, String description, Timestamp creTime) {
		this.state = state;
		this.macOwner = macOwner;
		this.longTel = longTel;
		this.address = address;
		this.description = description;
		this.creTime = creTime;
	}

	/** full constructor */
	public RepairClaim(Integer state, String macOwner, String longTel,
			String shortTel, String address, String machine, String system,
			Integer storage, String description, Timestamp creTime) {
		this.state = state;
		this.macOwner = macOwner;
		this.longTel = longTel;
		this.shortTel = shortTel;
		this.address = address;
		this.machine = machine;
		this.system = system;
		this.storage = storage;
		this.description = description;
		this.creTime = creTime;
	}

	// Property accessors
	
	public boolean isIsComment() {
		return isComment;
	}

	public void setIsComment(boolean isComment) {
		this.isComment = isComment;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMacOwnerId() {
		return macOwnerId;
	}

	public void setMacOwnerId(String macOwnerId) {
		this.macOwnerId = macOwnerId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMacOwner() {
		return this.macOwner;
	}

	public void setMacOwner(String macOwner) {
		this.macOwner = macOwner;
	}

	public String getLongTel() {
		return this.longTel;
	}

	public void setLongTel(String longTel) {
		this.longTel = longTel;
	}

	public String getShortTel() {
		return this.shortTel;
	}

	public void setShortTel(String shortTel) {
		this.shortTel = shortTel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMachine() {
		return this.machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Integer getStorage() {
		return this.storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreTime() {
		return this.creTime;
	}

	public void setCreTime(Timestamp creTime) {
		this.creTime = creTime;
	}

}