package com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public enum CalculationType {

    DIVISION('/') {
        public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
            try {
            return num1.divide(num2);
            } catch(ArithmeticException e) {
                if(num1.doubleValue() != 0 && num2.doubleValue() != 0) {
                return num1.divide(num2, RoundingMode.DOWN);
                } else {
                    return new BigDecimal(0);
                }
            }
        }
    },
    MULTIPLICATION('*') {
        public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
            return num1.multiply(num2, MathContext.DECIMAL128);
        }
    },
    ADDITION('+') {
        public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
            return num1.add(num2);
        }
    },
    SUBSTRACTION('-') {
        public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
            return num1.subtract(num2);
        }
    },
    POWEROF('^') {
        public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
            return num1.pow(num2.intValueExact(), MathContext.DECIMAL128);
        }
    };

    private char type;

    CalculationType(char type) {
        this.type = type;
    }

    public abstract BigDecimal calculate(BigDecimal num1, BigDecimal num2);

    public char getOperatorType() {
        return type;
    }

    public static boolean isCharacterAnOperator(char ch) {

        for (CalculationType calculationType : CalculationType.values()) {
            if (ch == calculationType.type) {
                return true;
            }
        }
        return false;
    }

    public static CalculationType getTypeDynamicly(char ch) {

        for(CalculationType calculationType: CalculationType.values()) {

            if(ch == calculationType.getOperatorType()) {
                return calculationType;
            }

        }
    return null;
    }
}

