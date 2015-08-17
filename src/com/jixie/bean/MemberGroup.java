package com.jixie.bean;
// default package



/**
 * MemberGroup entity. @author MyEclipse Persistence Tools
 */

public class MemberGroup  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;


    // Constructors

    /** default constructor */
    public MemberGroup() {
    }

    
    /** full constructor */
    public MemberGroup(String id, String name) {
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