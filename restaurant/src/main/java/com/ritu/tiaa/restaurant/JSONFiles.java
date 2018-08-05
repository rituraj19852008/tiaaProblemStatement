package com.ritu.tiaa.restaurant;

import java.io.FileNotFoundException;
import java.io.FileReader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFiles implements Files {

	BranchOrderDetails branchOrderDetails = new BranchOrderDetails();

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JSONFiles.class);

	public BranchOrderDetails readFile(String filename) {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(filename));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// Reading the String
			JSONObject name = (JSONObject) jsonObject.get("cmfoodchain");
			JSONObject branchDetails = (JSONObject) name.get("branch");
			JSONObject orders = (JSONObject) name.get("orders");
			JSONArray orderDetail = (JSONArray) orders.get("orderdetail");
			processOrders(orderDetail);
			processBranchDetails(branchDetails);

		} catch (FileNotFoundException fe) {
			logger.error("File Not Found Exception");
		} catch (Exception e) {
			logger.error("Exception occured");
		}
		return branchOrderDetails;
	}

	private void processOrders(JSONArray orderDetail) {
		for (int i = 0; i < orderDetail.size(); i++) {
			Order orderObject = new Order();
			JSONObject obj = (JSONObject) orderDetail.get(i);
			orderObject.setOrderid((String) obj.get("orderid").toString());
			orderObject.setBillAmount((String) obj.get("billamount").toString());
			branchOrderDetails.addOrder(orderObject);
		}
	}

	private void processBranchDetails(JSONObject branchDetails) {
		branchOrderDetails.setBranchLocation((String) branchDetails.get("location"));
		branchOrderDetails.setLocationid((String) branchDetails.get("locationid"));
		branchOrderDetails.setTotalcollection((String) branchDetails.get("totalcollection"));

	}

}
