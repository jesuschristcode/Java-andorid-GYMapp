package com.msku.example.finalproject;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgramFitnessTest {

    @Test
    public void testProgramFitnessConstructor() {
        // Arrange
        String testMonday = "Run";
        String testTuesday = "Swim";
        String testWednesday = "Yoga";
        String testThursday = "Weightlifting";
        String testFriday = "Rest";
        String testSaturday = "Cardio";
        String testSunday = "Hiking";

        // Act
        ProgramFitness programFitness = new ProgramFitness(testMonday, testTuesday, testWednesday, testThursday, testFriday, testSaturday, testSunday);

        // Assert
        assertEquals(testMonday, programFitness.getMonday());
        assertEquals(testTuesday, programFitness.getTuesday());
        assertEquals(testWednesday, programFitness.getWednesday());
        assertEquals(testThursday, programFitness.getThursday());
        assertEquals(testFriday, programFitness.getFriday());
        assertEquals(testSaturday, programFitness.getSaturday());
        assertEquals(testSunday, programFitness.getSunday());
    }

    @Test
    public void testProgramFitnessToString() {
        // Arrange
        String testMonday = "Run";
        String testTuesday = "Swim";
        String testWednesday = "Yoga";
        String testThursday = "Weightlifting";
        String testFriday = "Rest";
        String testSaturday = "Cardio";
        String testSunday = "Hiking";
        String expectedString = "ProgramFitness{" +
                "Monday='" + testMonday + '\'' +
                ", Tuesday='" + testTuesday + '\'' +
                ", Wednesday='" + testWednesday + '\'' +
                ", Thursday='" + testThursday + '\'' +
                ", Friday='" + testFriday + '\'' +
                ", Saturday='" + testSaturday + '\'' +
                ", Sunday='" + testSunday + '\'' +
                '}';

        // Act
        ProgramFitness programFitness = new ProgramFitness(testMonday, testTuesday, testWednesday, testThursday, testFriday, testSaturday, testSunday);

        // Assert
        assertEquals(expectedString, programFitness.toString());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        ProgramFitness programFitness = new ProgramFitness();
        String testMonday = "Run";
        String testTuesday = "Swim";
        String testWednesday = "Yoga";
        String testThursday = "Weightlifting";
        String testFriday = "Rest";
        String testSaturday = "Cardio";
        String testSunday = "Hiking";

        // Act
        programFitness.setMonday(testMonday);
        programFitness.setTuesday(testTuesday);
        programFitness.setWednesday(testWednesday);
        programFitness.setThursday(testThursday);
        programFitness.setFriday(testFriday);
        programFitness.setSaturday(testSaturday);
        programFitness.setSunday(testSunday);

        // Assert
        assertEquals(testMonday, programFitness.getMonday());
        assertEquals(testTuesday, programFitness.getTuesday());
        assertEquals(testWednesday, programFitness.getWednesday());
        assertEquals(testThursday, programFitness.getThursday());
        assertEquals(testFriday, programFitness.getFriday());
        assertEquals(testSaturday, programFitness.getSaturday());
        assertEquals(testSunday, programFitness.getSunday());
    }
}
