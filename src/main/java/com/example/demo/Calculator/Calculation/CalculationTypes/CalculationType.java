package com.example.demo.Calculator.Calculation.CalculationTypes;

public enum CalculationType {

    DIVISION('/') {
        @Override
        public Double calculate(double num1, double num2) {
            return num1 / num2;
        }
    }, MULTIPLICATION('*') {
        @Override
        public Double calculate(double num1, double num2) {
            return num1 * num2;
        }
    }, ADDITION('+') {
        @Override
        public Double calculate(double num1, double num2) {
            return num1 + num2;
        }
    }, SUBSTRACTION('-') {
        @Override
        public Double calculate(double num1, double num2) {
            return num1 - num2;
        }
    },
    POWEROF('^') {
        @Override
        public Double calculate(double num1, double num2) {
            return Math.pow(num1, num2);
        }
    };

    private char type;

    CalculationType(char type) {
        this.type = type;
    }

    public abstract Double calculate(double num1, double num2);

    public char getType() {
        return type;
    }

    public boolean contains(char ch) {

        for (CalculationType calculationType : CalculationType.values()) {
            if (ch == calculationType.type) {
                return true;
            }
        }
        return false;
    }
}

