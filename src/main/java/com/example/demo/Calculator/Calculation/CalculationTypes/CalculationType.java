package com.example.demo.Calculator.Calculation.CalculationTypes;

public enum CalculationType {

    DIVISION('/') {
        public Double calculate(double num1, double num2) {
            return num1 / num2;
        }
    },
    MULTIPLICATION('*') {
        public Double calculate(double num1, double num2) {
            return num1 * num2;
        }
    },
    ADDITION('+') {
        public Double calculate(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBSTRACTION('-') {
        public Double calculate(double num1, double num2) {
            return num1 - num2;
        }
    },
    POWEROF('^') {
        public Double calculate(double num1, double num2) {
            return Math.pow(num1, num2);
        }
    };

    private char type;

    CalculationType(char type) {
        this.type = type;
    }

    public abstract Double calculate(double num1, double num2);

    public char getOperatorType() {
        return type;
    }

    public boolean containsOperator(char ch) {

        for (CalculationType calculationType : CalculationType.values()) {
            if (ch == calculationType.type) {
                return true;
            }
        }
        return false;
    }
}

