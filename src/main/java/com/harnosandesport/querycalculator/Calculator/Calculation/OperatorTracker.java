package com.harnosandesport.querycalculator.Calculator.Calculation;

import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

public class OperatorTracker {

    private Integer indexStart;
    private Integer indexEnd;
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

    public OperatorTracker() {}

    public Integer getIndexStart() {
        return indexStart;
    }

    public Integer getIndexEnd() {
        return indexEnd;
    }

    public void setIndexStart(int indexStart) {
        this.indexStart = indexStart;
    }

    public void setIndexEnd(int indexEnd) {
        this.indexEnd = indexEnd;
    }
}