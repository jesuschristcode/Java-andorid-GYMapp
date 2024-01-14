package com.msku.example.finalproject;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserInfoTest {

    @Test
    public void testUserInfoConstructor() {
        // Arrange
        int testHeight = 170;
        int testWeight = 70;
        int testAge = 25;
        float testWaist = 32.5f;
        float testChest = 40.0f;
        float testArm = 14.0f;
        String testSex = "Male";
        String testFatRate = "15%";

        // Act
        UserInfo userInfo = new UserInfo(testHeight, testWeight, testAge, testWaist, testChest, testArm, testSex, testFatRate);

        // Assert
        assertEquals(testHeight, userInfo.getHeight());
        assertEquals(testWeight, userInfo.getWeight());
        assertEquals(testAge, userInfo.getAge());
        assertEquals(testWaist, userInfo.getWaist(), 0.001); // Using delta for float comparison
        assertEquals(testChest, userInfo.getChest(), 0.001);
        assertEquals(testArm, userInfo.getArm(), 0.001);
        assertEquals(testSex, userInfo.getSex());
        assertEquals(testFatRate, userInfo.getFatRate());
    }

    @Test
    public void testUserInfoToString() {
        // Arrange
        int testHeight = 170;
        int testWeight = 70;
        int testAge = 25;
        float testWaist = 32.5f;
        float testChest = 40.0f;
        float testArm = 14.0f;
        String testSex = "Male";
        String testFatRate = "15%";
        String expectedString = "UserInfo{" +
                "height=" + testHeight +
                ", weight=" + testWeight +
                ", age=" + testAge +
                ", waist=" + testWaist +
                ", chest=" + testChest +
                ", arm=" + testArm +
                ", sex='" + testSex + '\'' +
                ", fatRate='" + testFatRate + '\'' +
                '}';

        // Act
        UserInfo userInfo = new UserInfo(testHeight, testWeight, testAge, testWaist, testChest, testArm, testSex, testFatRate);

        // Assert
        assertEquals(expectedString, userInfo.toString());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        UserInfo userInfo = new UserInfo();
        int testHeight = 170;
        int testWeight = 70;
        int testAge = 25;
        float testWaist = 32.5f;
        float testChest = 40.0f;
        float testArm = 14.0f;
        String testSex = "Male";
        String testFatRate = "15%";

        // Act
        userInfo.setHeight(testHeight);
        userInfo.setWeight(testWeight);
        userInfo.setAge(testAge);
        userInfo.setWaist(testWaist);
        userInfo.setChest(testChest);
        userInfo.setArm(testArm);
        userInfo.setSex(testSex);
        userInfo.setFatRate(testFatRate);

        // Assert
        assertEquals(testHeight, userInfo.getHeight());
        assertEquals(testWeight, userInfo.getWeight());
        assertEquals(testAge, userInfo.getAge());
        assertEquals(testWaist, userInfo.getWaist(), 0.001);
        assertEquals(testChest, userInfo.getChest(), 0.001);
        assertEquals(testArm, userInfo.getArm(), 0.001);
        assertEquals(testSex, userInfo.getSex());
        assertEquals(testFatRate, userInfo.getFatRate());
    }
}
