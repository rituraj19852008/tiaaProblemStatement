package com.ritu.tiaa.restaurant;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class XMLFilesTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public XMLFilesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( XMLFilesTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testReadFileForInvalidFileName()
    {
    	Files xmlFile = new XMLFiles();
    	assertNull(xmlFile.readFile("invalid.json").getBranchLocation());
    	assertNull(xmlFile.readFile("invalid.json").getLocationid());
    	assertNull(xmlFile.readFile("invalid.json").getTotalcollection());
    }
}
