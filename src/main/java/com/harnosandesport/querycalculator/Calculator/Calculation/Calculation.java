package com.harnosandesport.querycalculator.Calculator.Calculation;

import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public interface Calculation {

        Calculation run(CalculationType type);
        String getResult();
}