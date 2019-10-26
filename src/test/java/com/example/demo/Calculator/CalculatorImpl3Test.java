package com.example.demo.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImpl3Test {

    Calculator calculator = new CalculatorImpl3();

    @Test
    public void testCalculatorSingleDivision() {

        assertEquals("10", calculator.calculate("100/10"));
    }

    @Test
    public void testCalculatorMultiDivision() {

        assertEquals("0.1", calculator.calculate("100/10/100"));
    }

    @Test
    public void testCalculatorMultiDivisionAndMultiplication() {

        assertEquals("100", calculator.calculate("100/10/100*1000"));
    }

    @Test
    public void testCalculatorMultiDivisionMultiplicationAndAddition() {

        assertEquals("2100", calculator.calculate("100/10/100*1000+2000"));
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
        //TODO:: Not sure about this result - a lot of calculators online gives -7300 as a result. Might need to check this out.
        assertEquals("-8500", calculator.calculate("100-100 * 400 / 5 + 600"));
    }

    @Test
    public void testPowerOf() {
        assertEquals("4", calculator.calculate("2^2"));

    }
}