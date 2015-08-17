package com.jixie.bean;

/**
 * Repsummary entity. @author MyEclipse Persistence Tools
 */

public class Repsummary implements java.io.Serializable {

	// Fields

	private String id;
	private String repairmemid;
	private String machine;
	private String description;
	private String label;
	private String solution;
	private Integer isShare;

	// Constructors

	/** default constructor */
	public Repsummary() {
	}

	/** full constructor */
	public Repsummary(String repclaimId, String machine, String description,
			String label, String solution, Integer isShare) {
		this.machine = machine;
		this.description = description;
		this.label = label;
		this.solution = solution;
		this.isShare = isShare;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getRepairmemid() {
		return repairmemid;
	}

	public void setRepairmemid(String repairmemid) {
		this.repairmemid = repairmemid;
	}

	public String getMachine() {
		return this.machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSolution() {
		return this.solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Integer getIsShare() {
		return this.isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

}