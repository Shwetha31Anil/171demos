package com.mphasis.training.hibernate.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bus {
	
	@Id
	private String bid;
	@Column(length = 15)
	private String bname;
	
	@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER)
	private List<Passenger> passengers=new ArrayList<>();
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	

}
