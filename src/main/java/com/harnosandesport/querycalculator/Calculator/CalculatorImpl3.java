package com.harnosandesport.querycalculator.Calculator;

import com.harnosandesport.querycalculator.Calculator.Calculation.Calculation;
import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationImpl;
import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public class CalculatorImpl3 implements Calculator {


@Override
public String calculate(String query) {

        query = query.replaceAll("[^0-9*-/+^()]", "");

        Calculation calculation = new CalculationImpl(query);

        calculation.calculate(CalculationType.POWEROF)
        .calculate(CalculationType.MULTIPLICATION)
        .calculate(CalculationType.ADDITION)
        .calculate(CalculationType.SUBSTRACTION);

        return calculation.getResult();
        }
}