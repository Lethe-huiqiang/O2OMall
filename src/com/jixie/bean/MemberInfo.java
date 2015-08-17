package com.jixie.bean;

import java.sql.Timestamp;

// default package



/**
 * MemberInfo entity. @author MyEclipse Persistence Tools
 */

public class MemberInfo  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String longTel;
     private String shortTel;
     private String departmentId;
     private String groupId;
     private Timestamp updateTime;

    // Constructors

    /** default constructor */
    public MemberInfo() {
    }

    
    /** full constructor */
    public MemberInfo(String id, String name, String longTel, String shortTel, String departmentId, String groupId,Timestamp updateTime) {
        this.id = id;
        this.name = name;
        this.longTel = longTel;
        this.shortTel = shortTel;
        this.departmentId = departmentId;
        this.groupId = groupId;
        this.updateTime=updateTime;
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

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


	public Timestamp getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
   








}