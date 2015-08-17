package com.jixie.bean;
// default package



/**
 * MemberDepartment entity. @author MyEclipse Persistence Tools
 */

public class MemberDepartment  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;


    // Constructors

    /** default constructor */
    public MemberDepartment() {
    }

    
    /** full constructor */
    public MemberDepartment(String id, String name) {
        this.id = id;
        this.name = name;
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
   








}