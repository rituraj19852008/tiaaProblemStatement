package com.ritu.tiaa.restaurant;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLFiles implements Files {

	BranchOrderDetails branchOrderDetails = new BranchOrderDetails();

	Logger logger = Logger.getLogger(XMLFiles.class);

	public BranchOrderDetails readFile(String filename) {
		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList branchDetails = doc.getElementsByTagName("branch");

			processDetails(branchDetails);

			NodeList orderDetials = doc.getElementsByTagName("orderdetail");

			processDetailsForOrders(orderDetials);

		} catch (Exception e) {
			logger.error("Fatal error occured");
		}
		return branchOrderDetails;
	}

	private void processDetails(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			NodeList orders = nNode.getChildNodes();
			for (int i = 0; i < orders.getLength(); i++) {
				Node order = orders.item(i);
				if (order.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) order;
					if (ele.getTagName().equalsIgnoreCase("location")) {
						branchOrderDetails.setBranchLocation(ele.getTextContent());
					} else if (ele.getTagName().equalsIgnoreCase("totalcollection")) {
						branchOrderDetails.setTotalcollection(ele.getTextContent());
					} else if (ele.getTagName().equalsIgnoreCase("locationid")) {
						branchOrderDetails.setLocationid(ele.getTextContent());
					}

				}
			}

		}
	}

	private void processDetailsForOrders(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			NodeList orders = nNode.getChildNodes();
			Order orderOject = new Order();
			for (int i = 0; i < orders.getLength(); i++) {

				Node order = orders.item(i);
				if (order.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) order;
					if (ele.getTagName().equalsIgnoreCase("orderid")) {

						orderOject.setOrderid(ele.getTextContent());
					} else if (ele.getTagName().equalsIgnoreCase("billamount")) {

						orderOject.setBillAmount(ele.getTextContent());
					}
				}
			}
			branchOrderDetails.addOrder(orderOject);
		}
	}

}
