package com.example.querycalculator.Calculator.Calculation;

import com.example.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;
import org.springframework.expression.spel.ast.Operator;

public class OperatorTracker {

    private int indexStart;
    private int indexEnd;
    private CalculationType calculationType;

    @Deprecated
    public OperatorTracker(int indexStart, int indexEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    public OperatorTracker(int indexStart, int indexEnd, CalculationType calculationType) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    public int getIndexStart() {
        return indexStart;
    }

    public int getIndexEnd() {
        return indexEnd;
    }
}