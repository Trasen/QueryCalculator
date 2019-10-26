package com.example.demo.Calculator.Calculation;

public class OperatorTracker {

    private int indexStart;
    private int indexEnd;

    public OperatorTracker(int indexStart, int indexEnd) {
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