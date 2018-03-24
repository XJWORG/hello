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
@Entity(name = "t_task_list")
public class Task implements java.io.Serializable {

	// Fields

	private Integer id;
    private Integer taskType;
    // 父任务id
    private Integer pId;
	private String taskName;
	private String context;
	private Integer kpiType;
	private Integer importantLevel;
    private Integer hardLevel;
    private Integer active;
    private String common;
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskname=" + taskName + ", context="
				+ context + ", active=" + active + ", common=" + common + "]";
	}

	// Constructors
	/** default constructor */
	public Task() {
	}


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    @Column(name = "task_type", length = 10)
    public Integer getTaskType() {
        return this.taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    @Column(name = "p_id", length = 10)
    public Integer getPid() {
        return this.pId;
    }

    public void setPid(Integer pId) {
        this.pId = pId;
    }

    @Column(name = "kpi_type", length = 3)
    public Integer getKpiType() {
        return this.kpiType;
    }

    public void setKpiType(Integer kpiType) {
        this.kpiType = kpiType;
    }

    @Column(name = "important_level", length = 3)
    public Integer getImportantLevel() {
        return this.importantLevel;
    }

    public void setImportantLevel(Integer importantLevel) {
        this.importantLevel = importantLevel;
    }
    
    @Column(name = "hard_level", length = 3)
    public Integer getHardLevel() {
        return this.hardLevel;
    }

    public void setHardLevel(Integer hardLevel) {
        this.hardLevel = hardLevel;
    }
    
	@Column(name = "taskname", length = 20)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "context", length = 512)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
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