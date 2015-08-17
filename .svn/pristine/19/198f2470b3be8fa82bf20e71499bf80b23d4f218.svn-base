package com.jixie.bean;

import java.sql.Timestamp;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * Commodity entity. @author MyEclipse Persistence Tools
 */

@Searchable(alias="commodity")
public class Commodity implements java.io.Serializable {

	// Fields
	@SearchableId
	private String id;              //商品ID
	@SearchableProperty(name="name",boost=2.0F, index=Index.ANALYZED, store=Store.YES)
	private String name;            //商品名称
	private Integer inventory;      //商品库存
	private String category ;       //商品类目
	@SearchableProperty(name="price",index=Index.NOT_ANALYZED, store=Store.YES)
	private Float price;            //商品单价
	private Integer salesvolume;    //商品销量
	private String description;     //商品描述
	private String company;         //商品所属商家
	@SearchableProperty(name="brand",boost=2.0F, index=Index.ANALYZED, store=Store.YES)
	private String brand;           //商品品牌
	@SearchableProperty(index=Index.NOT_ANALYZED, store=Store.YES)
	private String picId;           //商品图片
	private Integer state;          //商家状态
	private Timestamp updateTime;   //更新时间
	private Timestamp createTime;   //发布时间
	@SearchableComponent
	private FileSource fileSource;//商品图片
	
	private int buynum;
	// Constructors

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/** default constructor */
	public Commodity() {
	}

	/** full constructor */
	public Commodity(String id, String name, Integer inventory, Float price,
			String description, String company, String brand, String picId,
			Integer state, Timestamp updateTime, Timestamp createTime) {
		this.id = id;
		this.name = name;
		this.inventory = inventory;
		this.price = price;
		this.description = description;
		this.company = company;
		this.brand = brand;
		this.picId = picId;
		this.state = state;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	// Property accessors
    
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	@SearchableProperty(index=Index.NOT_ANALYZED, store=Store.YES)
	public Integer getSalesvolume() {
		return salesvolume;
	}

	public void setSalesvolume(Integer salesvolume) {
		this.salesvolume = salesvolume;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getPicId() {
		return this.picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public FileSource getFileSource() {
		return fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}



	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}