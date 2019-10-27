package com.example.querycalculator.Calculator.Calculation;

import com.example.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public interface Calculation {

        Calculation calculate(CalculationType type);
        String getResult();
}