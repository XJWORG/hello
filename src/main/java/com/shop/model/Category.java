package com.shop.model;

import javax.persistence.*;

@Entity(name = "category")
public class Category implements java.io.Serializable {

	private Integer id;
	private String type;
	private Boolean hot;

	public Category() {

	}

	public Category(String type, Boolean hot) {
		this.type = type;
		this.hot = hot;
	}

    public Category(Integer id, String type, Boolean hot) {
        this.id = id;
        this.type = type;
        this.hot = hot;
    }

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "hot")
	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}
