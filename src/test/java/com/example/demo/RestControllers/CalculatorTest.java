package com.example.demo.RestControllers;

import com.example.demo.Calculator.Calculator;
import com.example.demo.Calculator.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.*;

@Deprecated
public class CalculatorTest {

    Calculator calculator = new CalculatorImpl();


    @Test
    public void testCalculatorSingleAdditions() {

        assertEquals("20",calculator.calculate("5+5+5+5"));
    }

    @Test
    public void testCalculatorMultiAdditions() {

        assertEquals("200", calculator.calculate("50+50+50+50"));

    }

    @Test
    public void testCalculatorDecimalAddition() {
        assertEquals("4.5", calculator.calculate("4 + 0.5"));
    }

    @Test
    public void testCalculatorMultiplication()  {
        assertEquals("200", calculator.calculate("50*4"));
    }

    @Test
    public void testCalculatorMultiplicationDecimal() {
        assertEquals("1000.5", calculator.calculate("500.25 * 2"));
    }

    @Test
    public void testCalculatorMultiplicationMultiValues() {
        assertEquals("100", calculator.calculate("5*5*2*2"));
    }

    @Test
    public void testCalculatorMultiplicationAndAddition() {
        assertEquals("75", calculator.calculate("25+25*2"));
    }

    @Test
    public void testCalculatorMultiplicationAndAdditionMulti() {
        assertEquals("205", calculator.calculate("50+50+25+10*2*4"));
    }
}