package com.ritu.tiaa.restaurant;

public class Branch {
	
	public Branch(String location, String totalcollection, String sumoforder, String locationid) {
		super();
		this.location = location;
		this.totalcollection = totalcollection;
		this.sumoforder = sumoforder;
		this.locationid = locationid;
	}
	private String location;
	private String totalcollection;
	private String sumoforder;
	private String locationid;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTotalcollection() {
		return totalcollection;
	}
	public void setTotalcollection(String totalcollection) {
		this.totalcollection = totalcollection;
	}
	public String getSumoforder() {
		return sumoforder;
	}
	public void setSumoforder(String sumoforder) {
		this.sumoforder = sumoforder;
	}
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	
	
	
	
	

}
