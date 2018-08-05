package com.ritu.tiaa.restaurant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritu.tiaa.restaurant.Files;
import com.ritu.tiaa.restaurant.JSONFiles;
import com.ritu.tiaa.restaurant.XMLFiles;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Files xmlfile = new  XMLFiles();
    	BranchOrderDetails branchOrderDetailsForXML = xmlfile.readFile("src/main/java/com/ritu/tiaa/testdata/BOM-1234.xml");
        Files jsonFiles = new  JSONFiles();
        BranchOrderDetails branchOrderDetailsForJSON = jsonFiles.readFile("src/main/java/com/ritu/tiaa/testdata/BOM-4567.json");
        processFilesAndGenerateResult(branchOrderDetailsForXML,branchOrderDetailsForJSON);
        System.out.println("Success");
    }

	private static void processFilesAndGenerateResult(BranchOrderDetails branchOrderDetailsForXML,
			BranchOrderDetails branchOrderDetailsForJSON) {
		ObjectMapper mapper = new ObjectMapper();
		Result result = new Result();
		List<BranchOrderDetails> orders = new ArrayList<BranchOrderDetails>();
		orders.add(branchOrderDetailsForXML);
		orders.add(branchOrderDetailsForJSON);
		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("src/main/java/com/ritu/tiaa/output/mismatch.json"), processResult(orders));
			mapper.writeValue(new File("src/main/java/com/ritu/tiaa/output/match.json"), new JSONObject());

			

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Result processResult(List<BranchOrderDetails> orders) {
		List<Result> results = new ArrayList<Result>();
		CMFoodChain foodchain = new CMFoodChain();
		for (BranchOrderDetails order : orders) {
			Result result;
			List<Order> totalOrders = order.getOrders();
			int totalBill = 0;
			for (Order order2 : totalOrders) {
				totalBill = (int) (totalBill+Double.parseDouble((order2.getBillAmount().replaceAll("^\"|\"$", ""))));
			}
			
			foodchain.addBranch(new Branch(order.getBranchLocation(), order.getTotalcollection(), String.valueOf(totalBill).concat(".00"), order.getLocationid()));
			result = new Result(foodchain);
			results.add(result);
		}
		
		return results.get(0);
	}

		public static String replace(String str) {
			return str.replaceAll("^\"|\"$", "");

		}

}
