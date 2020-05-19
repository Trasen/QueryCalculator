package com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTypeTest {

    @Test
    public void getTypeDynamiclyAddition() {
    assertEquals(CalculationType.ADDITION, CalculationType.getTypeDynamically('+'));
    }

    @Test
    public void getTypeDynamiclyMultiplication() {
        assertEquals(CalculationType.MULTIPLICATION, CalculationType.getTypeDynamically('*'));
    }

    @Test
    public void getTypeDynamiclyDivision() {
        assertEquals(CalculationType.DIVISION, CalculationType.getTypeDynamically('/'));
    }

    @Test
    public void getTypeDynamiclyPowerOf() {
        assertEquals(CalculationType.POWEROF, CalculationType.getTypeDynamically('^'));
    }

    @Test
    public void getTypeDynamiclySubstration() {
        assertEquals(CalculationType.SUBSTRACTION, CalculationType.getTypeDynamically('-'));
    }
}