package com.harnosandesport.querycalculator.Calculator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorImpl3Test {

    Calculator calculator = new CalculatorImpl3();

    @Test
    public void testCalculatorSingleDivision() {

        assertEquals("10", calculator.calculate("100/10"));
    }

    @Test
    public void calculateNestedExpressions() {
        assertEquals("75000", calculator.calculate("(100+200) * (50+200)"));
    }

    @Test
    public void calculateNestedNestedExpressions() {
        assertEquals("75000", calculator.calculate("(100+(50*4)) * (50+(100+100))"));
    }

    @Test
    public void testCalculatorMultiDivision() {

        assertEquals("0.1", calculator.calculate("100/10/100"));
    }

    @Test
    public void testCalculatorMultiDivisionAndMultiplication() {

        assertEquals("100.0", calculator.calculate("100/10/100*1000"));
    }

    @Test
    public void testCalculatorMultiDivisionMultiplicationAndAddition() {

        assertEquals("2100.0", calculator.calculate("100/10/100*1000+2000"));
    }

    @Test
    public void testCalculatorMultiSwapped() {
        assertEquals("8700", calculator.calculate("200+100+400+200*200/5"));
    }

    @Test
    public void testCalculatorMultiSwappedMixed() {
        assertEquals("940", calculator.calculate("200+100+200/5+400+200"));
    }

    @Test
    public void testCalculatorMultiSwappedMixedMixed() {
        assertEquals("940", calculator.calculate("200+100+200/5+400+200"));
    }

    @Test
    public void testCalculatorSubstration() {
        assertEquals("0", calculator.calculate("100-100"));
    }

    @Test
    public void testCalculatorSubstrationDivisionMultiplicationAndAddition() {
        assertEquals("-7300", calculator.calculate("100-100 * 400 / 5 + 600"));
    }

    @Test
    public void testPowerOf() {
        assertEquals("4", calculator.calculate("2^2"));
    }

    @Test
    public void veryLargeValues() {
        assertEquals("99999999998999900000000001", calculator.calculate("99999999999*999999999999999"));
    }

    @Test
    public void veryVeryLargeValues() {
        assertEquals(299999, calculator.calculate("100.0^99999").length());
    }
}