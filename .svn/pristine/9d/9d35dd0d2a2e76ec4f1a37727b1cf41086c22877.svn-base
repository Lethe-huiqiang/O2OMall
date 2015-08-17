package com.jixie.bean;

import java.sql.Timestamp;
import java.util.List;


/**
 * SharePost entity. @author MyEclipse Persistence Tools
 */

public class SharePost  implements java.io.Serializable {


    // Fields    

     private String id;
     private String postId;
     private String area;
     private String title;
     private String content;
     private String parentPostId;
     private String ownerId;
     private Timestamp createTime;

     private List childAnswerList;//回复list
     private String sharePostOwner;//发帖人昵称

    // Constructors

    /** default constructor */
    public SharePost() {
    }

	/** minimal constructor */
    public SharePost(String id, String postId, String area, String title, String parentPostId, String ownerId, Timestamp createTime) {
        this.id = id;
        this.postId = postId;
        this.area = area;
        this.title = title;
        this.parentPostId = parentPostId;
        this.ownerId = ownerId;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public SharePost(String id, String postId, String area, String title, String content, String parentPostId, String ownerId, Timestamp createTime) {
        this.id = id;
        this.postId = postId;
        this.area = area;
        this.title = title;
        this.content = content;
        this.parentPostId = parentPostId;
        this.ownerId = ownerId;
        this.createTime = createTime;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return this.postId;
    }
    
    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getParentPostId() {
        return this.parentPostId;
    }
    
    public void setParentPostId(String parentPostId) {
        this.parentPostId = parentPostId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }
    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

	public List getChildAnswerList() {
		return childAnswerList;
	}

	public void setChildAnswerList(List childAnswerList) {
		this.childAnswerList = childAnswerList;
	}

	public String getSharePostOwner() {
		return sharePostOwner;
	}

	public void setSharePostOwner(String sharePostOwner) {
		this.sharePostOwner = sharePostOwner;
	}
   








}