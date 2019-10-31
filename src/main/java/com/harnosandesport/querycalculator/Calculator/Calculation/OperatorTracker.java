package com.harnosandesport.querycalculator.Calculator.Calculation;

import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

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