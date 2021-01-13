package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags_tbl")
public class Tags extends BaseEntity {
	
	public Tags(String name) {
		super();
		this.name = name;
	}

	public Tags() {
		super();
	}
	
	@Column(length = 10)
	private String name;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "blogs_tags", 
	joinColumns = @JoinColumn(name = "tags_id"),
	inverseJoinColumns = @JoinColumn(name = "blogs_id"))
	List<Blog> blogs;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tags [name=" + name + "]";
	}
	
	

}
