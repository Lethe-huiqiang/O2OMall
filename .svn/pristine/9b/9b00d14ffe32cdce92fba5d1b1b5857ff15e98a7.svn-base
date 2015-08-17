package com.jixie.bean;
// default package

import java.sql.Timestamp;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;
import org.hibernate.annotations.Entity;


/**
 * FileSource entity. @author MyEclipse Persistence Tools
 */

@Searchable(root=false)
public class FileSource  implements java.io.Serializable {


    // Fields    
	 @SearchableProperty(name="filesourceid",index=Index.NOT_ANALYZED,store=Store.YES)  
     private String id;
     private String fileName;
     private String extendName;
     @SearchableProperty(index=Index.NOT_ANALYZED,store=Store.YES)  
     private String path;
     private Integer size;
     private Timestamp updateTime;


    // Constructors

    /** default constructor */
    public FileSource() {
    }

    
    /** full constructor */
    public FileSource(String id, String fileName, String extendName, String path, Integer size, Timestamp updateTime) {
        this.id = id;
        this.fileName = fileName;
        this.extendName = extendName;
        this.path = path;
        this.size = size;
        this.updateTime = updateTime;
    }

   
    // Property accessors
    @SearchableId
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtendName() {
        return this.extendName;
    }
    
    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }

    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSize() {
        return this.size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
   








}