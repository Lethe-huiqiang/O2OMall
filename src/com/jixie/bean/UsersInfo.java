package com.jixie.bean;
// default package

import java.sql.Timestamp;


/**
 * UsersInfo entity. @author MyEclipse Persistence Tools
 */

public class UsersInfo  implements java.io.Serializable {


    // Fields    

     private String id;
     private String nickname;
     private String email;
     private Integer status;
     private String pictureId;
     private Integer grade;
     private String registCode;
     private String usersCode;
     private String major;
     private Timestamp updateTime;

     private FileSource fileSource;//会员头像

    // Constructors

    /** default constructor */
    public UsersInfo() {
    }

	/** minimal constructor */
    public UsersInfo(String id, String nickname, String email, Integer status, String pictureId, Integer grade, String registCode, Timestamp updateTime) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.status = status;
        this.pictureId = pictureId;
        this.grade = grade;
        this.registCode = registCode;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public UsersInfo(String id, String nickname, String email, Integer status, String pictureId, Integer grade, String registCode, String usersCode, String major, Timestamp updateTime) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.status = status;
        this.pictureId = pictureId;
        this.grade = grade;
        this.registCode = registCode;
        this.usersCode = usersCode;
        this.major = major;
        this.updateTime = updateTime;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPictureId() {
        return this.pictureId;
    }
    
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getRegistCode() {
        return this.registCode;
    }
    
    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getUsersCode() {
        return this.usersCode;
    }
    
    public void setUsersCode(String usersCode) {
        this.usersCode = usersCode;
    }

    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

	public FileSource getFileSource() {
		return fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

}