package com.example.querycalculator.Calculator;

public interface OperationHandler {
    Number calculate(String query);
    OperationHandler setNext(OperationHandler handler);
}
