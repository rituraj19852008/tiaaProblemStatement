package com.ritu.tiaa.restaurant;

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
        xmlfile.readFile("src/main/java/com/ritu/tiaa/testdata/BOM-1234.xml");
        Files jsonFiles = new  JSONFiles();
        jsonFiles.readFile("src/main/java/com/ritu/tiaa/testdata/BOM-4567.json");
        System.out.println("Success");
    }
}
