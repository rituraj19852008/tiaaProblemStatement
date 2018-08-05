package com.ritu.tiaa.restaurant;

import java.util.ArrayList;
import java.util.List;

public class BranchOrderDetails {
	
	private String branchLocation;
	private String totalcollection;
	public String getTotalcollection() {
		return totalcollection;
	}
	public void setTotalcollection(String totalcollection) {
		this.totalcollection = totalcollection;
	}
	private String locationid;
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	private List<Order> orders = new ArrayList<Order>();
	public String getBranchLocation() {
		return branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void addOrder(Order order) {
		orders.add(order);
	}

}
