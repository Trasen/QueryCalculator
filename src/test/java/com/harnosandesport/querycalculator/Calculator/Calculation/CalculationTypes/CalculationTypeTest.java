package com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTypeTest {

    @Test
    public void getTypeDynamiclyAddition() {
    assertEquals(CalculationType.ADDITION, CalculationType.getTypeDynamicly('+'));
    }

    @Test
    public void getTypeDynamiclyMultiplication() {
        assertEquals(CalculationType.MULTIPLICATION, CalculationType.getTypeDynamicly('*'));
    }

    @Test
    public void getTypeDynamiclyDivision() {
        assertEquals(CalculationType.DIVISION, CalculationType.getTypeDynamicly('/'));
    }

    @Test
    public void getTypeDynamiclyPowerOf() {
        assertEquals(CalculationType.POWEROF, CalculationType.getTypeDynamicly('^'));
    }

    @Test
    public void getTypeDynamiclySubstration() {
        assertEquals(CalculationType.SUBSTRACTION, CalculationType.getTypeDynamicly('-'));
    }
}