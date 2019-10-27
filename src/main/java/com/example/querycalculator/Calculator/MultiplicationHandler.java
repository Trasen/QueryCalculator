package com.example.querycalculator.Calculator;

public class MultiplicationHandler implements OperationHandler {


    private OperationHandler next = null;

    @Override
    public Number calculate(String query) {

        System.out.println("Multiplication handler");


        for (String e: query.split("[*/]")) {
            System.out.printf(": " + e);
        }


        String result = "0";

        if(next != null)
            return next.calculate(result);

        return Double.valueOf(result);
    }

    @Override
    public OperationHandler setNext(OperationHandler handler) {

        this.next = handler;
        return this.next;

    }

}
