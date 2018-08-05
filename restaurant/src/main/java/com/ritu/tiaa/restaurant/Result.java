package com.ritu.tiaa.restaurant;

public class Result {
	
	private CMFoodChain cmfoodchain;

	public CMFoodChain getCmfoodchain() {
		return cmfoodchain;
	}

	public void setCmfoodchain(CMFoodChain cmfoodchain) {
		this.cmfoodchain = cmfoodchain;
	}

	public Result() {
		super();
	}

	public Result(CMFoodChain cmfoodchain) {
		super();
		this.cmfoodchain = cmfoodchain;
	}

}
