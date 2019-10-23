package com.example.demo.RestControllers;

import com.example.demo.Calculator.Calculator;
import com.example.demo.Calculator.CalculatorImpl2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorImpl2Test {


    Calculator calculator = new CalculatorImpl2();


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

    /*@Test
    public void testCalculatorMultiSwapped() {

        assertEquals("2100", calculator.calculate("200+100+400+200*200/5"));
    } */

}
