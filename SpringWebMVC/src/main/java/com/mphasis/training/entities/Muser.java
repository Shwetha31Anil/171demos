package com.mphasis.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Muser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(length = 20, unique = true,nullable = false)
	private String username;
	@Column(length = 8, nullable = false)
	private String pass;
	@Column(length=10, columnDefinition = "varchar(10) default 'customer'")
	private String role;
	@Column(length = 35, columnDefinition = "date default sysdate")
	private String createdDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * public static enum RoleType { CUSTOMER, ADMIN }
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE) private int userid;
	 * 
	 * @Column(length=20, nullable = false, unique = true) private String username;
	 * 
	 * @Column(length=20, nullable = false) private String pass;
	 * 
	 * @Column(length=20, columnDefinition = "varchar(20) default 'customer'")
	 * 
	 * 
	 * @Enumerated(EnumType.STRING)
	 * 
	 * @Column(length=20) private RoleType role;
	 * 
	 * @Column(length = 45, columnDefinition = "date default sysdate") private
	 * String createdDate; public int getUserid() { return userid; } public void
	 * setUserid(int userid) { this.userid = userid; } public String getUsername() {
	 * return username; } public void setUsername(String username) { this.username =
	 * username; } public String getPass() { return pass; } public void
	 * setPass(String pass) { this.pass = pass; } public RoleType getRole() { return
	 * role; } public void setRole(RoleType role) { this.role = role; } public
	 * String getCreatedDate() { return createdDate; } public void
	 * setCreatedDate(String createdDate) { this.createdDate = createdDate; }
	 * 
	 */

}
