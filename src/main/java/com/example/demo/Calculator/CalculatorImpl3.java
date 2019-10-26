package com.example.demo.Calculator;

import com.example.demo.Calculator.Calculation.Calculation;
import com.example.demo.Calculator.Calculation.CalculationImpl;
import com.example.demo.Calculator.Calculation.CalculationTypes.CalculationType;

public class CalculatorImpl3 implements Calculator {

    Calculation calculation = new CalculationImpl();

    @Override
    public String calculate(String query) {

        query = query.replaceAll("[^0-9*-/+^]", "");

        System.out.println(query);
        query = calculation.calculate(query, CalculationType.POWEROF);
        System.out.println(query);

        query = calculation.calculate(query, CalculationType.DIVISION);
        System.out.println(query);

        query = calculation.calculate(query, CalculationType.MULTIPLICATION);
        System.out.println(query);

        query = calculation.calculate(query, CalculationType.ADDITION);
        System.out.println(query);

        query = calculation.calculate(query, CalculationType.SUBSTRACTION);
        System.out.println(query);

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