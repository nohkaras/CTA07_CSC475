package com.sara.cta07_unitconverterapp;

// Imports the JUnit classes for testing
import org.junit.Test;
import static org.junit.Assert.*;

// Unit test class for the ConverterUnit class
public class ConverterUnitTest {

    @Test  // Test method for kmToM conversion method
    public void testKmToM() {

        assertEquals(1000.0, ConverterUnit.kmToM(1.0), 0.0);
    }
    @Test // Test method for kmToCm conversion method
    public void testKmToCm() {

        assertEquals(100000.0, ConverterUnit.kmToCm(1.0), 0.0);
    }

    @Test // Test method for kmToMile conversion method
    public void testKmToMile() {

        assertEquals(1.0, ConverterUnit.kmToMile(1.609), 0.0);
    }
    @Test // Test method for kmToYard conversion method
    public void testKmToYard() {

        assertEquals(1094.0, ConverterUnit.kmToYard(1.0), 0.0);
    }
    @Test // Test method for kmToFoot conversion method
    public void testKmToFoot() {

        assertEquals(3281.0, ConverterUnit.kmToFoot(1.0), 0.0);
    }
    @Test // Test method for kmToInch conversion method
    public void testKmToInch() {

        assertEquals(39370.0, ConverterUnit.kmToInch(1.0), 0.0);
    }
}
