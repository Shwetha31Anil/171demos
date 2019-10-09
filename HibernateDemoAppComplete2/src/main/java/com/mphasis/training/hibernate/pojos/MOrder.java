package com.mphasis.training.hibernate.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MOrder implements Serializable{
	
	
	@Override
	public String toString() {
		return "MOrder [orderId=" + orderId + ", pname=" + pname + ", product=" + product + "]";
	}
	@Id
	private int orderId;
	private String pname;

	
	  @OneToMany(cascade = CascadeType.ALL) 
	  private List<Product> product;
	 
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	  public List<Product> getProduct() { return product; } 
	  public void setProduct(List<Product> product) { 
		  this.product = product; }
	 
	

}
