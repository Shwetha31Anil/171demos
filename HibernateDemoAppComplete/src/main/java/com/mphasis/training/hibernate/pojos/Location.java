package com.mphasis.training.hibernate.pojos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Location {

	@Id
	private int locId;
	private String lname;
	@ManyToMany(mappedBy="locations", cascade = CascadeType.ALL,
			fetch=FetchType.EAGER)
	private List<Department> deps=new ArrayList<>();
	public List<Department> getDeps() {
		return deps;
	}
	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
}
