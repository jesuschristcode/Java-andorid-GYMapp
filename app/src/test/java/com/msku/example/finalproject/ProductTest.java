package com.msku.example.finalproject;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductConstructor() {
        // Arrange
        String testName = "TestProduct";
        String testValue = "TestValue";

        // Act
        Product product = new Product(testName, testValue);

        // Assert
        assertEquals(testName, product.getName());
        assertEquals(testValue, product.getValue());
    }

    @Test
    public void testProductToString() {
        // Arrange
        String testName = "TestProduct";
        String testValue = "TestValue";
        String expectedString = "Product{name='TestProduct', value=TestValue}";

        // Act
        Product product = new Product(testName, testValue);

        // Assert
        assertEquals(expectedString, product.toString());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        String testName = "TestProduct";
        String testValue = "TestValue";
        Product product = new Product();

        // Act
        product.setName(testName);
        product.setValue(testValue);

        // Assert
        assertEquals(testName, product.getName());
        assertEquals(testValue, product.getValue());
    }
}
