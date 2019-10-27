package com.example.querycalculator.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChainOfResponsibilityCalculatorTest {

    Calculator calculator = new ChainOfResponsibilityCalculator();

    @Test
    public void calculate() {

        calculator.calculate("1*2+31/2-3");

    }
}