package com.shop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity(name = "t_project_list")
public class Project implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String projectname;
	private String description;
	private Integer active;
	private String common;
	
	@Override
	public String toString() {
		return "Product [sid=" + sid + ", projectname=" + projectname + ", description="
				+ description + ", active=" + active + ", common=" + common + "]";
	}

	// Constructors
	/** default constructor */
	public Project() {
	}


	public Project(Integer sid, String projectname, String description, Integer active,
			String common ) {
		super();
		this.sid = sid;
		this.projectname = projectname;
		this.description = description;
		this.active = active;
		this.common = common;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "projectname", length = 20)
	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "active", length = 2)
	public Boolean getActive() {
	    if(this.active==1)
	    {
	        return true ;
	    }
	    return false;
	}

	public void setActive(Boolean bactive) {
	    if(bactive == true) {
	        this.active = 1;
	    }else{
	        this.active = 0;
	    }
	}

	@Column(name = "common")
	public String getCommon() {
		return this.common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

}