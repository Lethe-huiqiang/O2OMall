package com.jixie.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private String id;
	private String usersId;
	private String comment;
	private Float price;
	private Integer state;
	private String usersPhone;
	private String receiver;
	private String receiverInfo;
	private Timestamp createTime;
	private Timestamp updateTime;
	private List <OrderItem> list; //引用订单项列表

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String id, String usersId,String comment, Integer state, 
			Float price, String usersPhone,	String receiverInfo, 
			Timestamp createTime, Timestamp updateTime) {
		this.id = id;
		this.usersId = usersId;		
		this.comment = comment;
		this.state = state;
		this.price=price;
		this.usersPhone = usersPhone;
		this.receiverInfo = receiverInfo;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}


	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getUsersPhone() {
		return this.usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public String getReceiverInfo() {
		return this.receiverInfo;
	}

	public void setReceiverInfo(String receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

}