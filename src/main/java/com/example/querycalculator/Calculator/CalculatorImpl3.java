package com.example.querycalculator.Calculator;

import com.example.querycalculator.Calculator.Calculation.Calculation;
import com.example.querycalculator.Calculator.Calculation.CalculationImpl;
import com.example.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public class CalculatorImpl3 implements Calculator {

    Calculation calculation = new CalculationImpl();

    @Override
    public String calculate(String query) {

        query = query.replaceAll("[^0-9*-/+^]", "");
        query = calculation.calculate(query, CalculationType.POWEROF);

        //Division and multiplication is made at the same time. Logic for this is within calculate() implementation.
        query = calculation.calculate(query, CalculationType.MULTIPLICATION);
        query = calculation.calculate(query, CalculationType.ADDITION);
        query = calculation.calculate(query, CalculationType.SUBSTRACTION);

        Number response = Double.valueOf(query);

        if (isDouble(response)) {
            return String.valueOf(response.doubleValue());
        } else {
            return String.valueOf(response.longValue());
        }
    }

    private boolean isDouble(Number number) {

        if ((number.doubleValue() % 1) == 0) {
            return false;
        } else {
            return true;

        }
    }

}