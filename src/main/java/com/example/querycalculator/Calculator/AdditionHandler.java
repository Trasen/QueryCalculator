package com.example.querycalculator.Calculator;

public class AdditionHandler implements OperationHandler {

    private OperationHandler next = null;

    @Override
    public Number calculate(String query) {

        System.out.println("Addition handler");

        if(next != null)
            return next.calculate(query);

        return null;
    }

    @Override
    public OperationHandler setNext(OperationHandler handler) {

        this.next = handler;
        return this.next;
    }

}