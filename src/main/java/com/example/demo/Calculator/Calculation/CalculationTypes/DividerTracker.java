package com.example.demo.Calculator.Calculation.CalculationTypes;

public class DividerTracker {

    private int indexStart;
    private int indexEnd;

    public DividerTracker(int indexStart, int indexEnd) {
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