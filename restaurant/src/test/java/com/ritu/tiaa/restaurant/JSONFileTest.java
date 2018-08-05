package com.ritu.tiaa.restaurant;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class JSONFileTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JSONFileTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JSONFileTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testReadFileForInvalidFileName()
    {
    	Files xmlFile = new XMLFiles();
    	assertNull(xmlFile.readFile("invalid.xml").getBranchLocation());
    	assertNull(xmlFile.readFile("invalid.xml").getLocationid());
    	assertNull(xmlFile.readFile("invalid.xml").getTotalcollection());
    }
}
