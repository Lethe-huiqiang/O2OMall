package com.jixie.bean;

import java.sql.Timestamp;


/**
 * Activation entity. @author MyEclipse Persistence Tools
 */

public class Activation  implements java.io.Serializable {


    // Fields    

     private String id;
     private String usersId;
     private String activationKey;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public Activation() {
    }

    
    /** full constructor */
    public Activation(String id, String usersId, String activationKey, Timestamp createTime) {
        this.id = id;
        this.usersId = usersId;
        this.activationKey = activationKey;
        this.createTime = createTime;
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

    public String getActivationKey() {
        return this.activationKey;
    }
    
    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}