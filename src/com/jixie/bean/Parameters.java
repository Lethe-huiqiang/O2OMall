package com.jixie.bean;

import com.jixie.utils.IListItem;

public class Parameters { 

     private String id;
     private String name;
     private String value;
     private int category = -1;
     private String description;
     
     public String getId() {
    	 return id;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getValue() {
		 return value;
	 }
	 public void setValue(String value) {
		 this.value = value;
	 }
	 public int getCategory() {
		 return category;
	 }
	 public void setCategory(int category) {
		 this.category = category;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public void setDescription(String description) {
		 this.description = description;
	 }

}