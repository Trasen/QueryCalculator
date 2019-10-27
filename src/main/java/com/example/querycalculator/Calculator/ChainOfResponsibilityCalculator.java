package com.example.querycalculator.Calculator;

public class ChainOfResponsibilityCalculator implements Calculator {
    @Override
    public String calculate(String query) {



        OperationHandler mHandler = new MultiplicationHandler();
        OperationHandler dHandler = new DivisionHandler();
        OperationHandler aHandler = new AdditionHandler();
        OperationHandler sHandler = new SubtractionHandler();
        mHandler.setNext(dHandler);
        dHandler.setNext(aHandler);
        aHandler.setNext(sHandler);

        return String.valueOf(mHandler.calculate(query));
    }
}
