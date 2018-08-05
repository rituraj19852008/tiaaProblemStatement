package com.ritu.tiaa.restaurant;

import java.util.ArrayList;
import java.util.List;

public class CMFoodChain {
	
	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	private List<Branch> branches = new ArrayList<Branch>();
	
	public void addBranch(Branch branch) {
		branches.add(branch);
	}

}
