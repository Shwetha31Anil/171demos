package com.mphasis.training.pojos;

public class Address {
	private String street,city,country;
	public void init() {
		System.out.println("initalized");
	}
	
	public void destroy() {
		System.out.println("destroyes");
	}
	public Address() {
		System.out.println("Address Called");
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", country=" + country + ", pincode=" + pincode + "]";
	}
	private int pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
