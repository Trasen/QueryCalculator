package com.example.querycalculator.Calculator.Calculation;

import com.example.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public interface Calculation {

        String calculate(String query, CalculationType type);
        }