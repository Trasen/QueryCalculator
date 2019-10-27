package com.example.querycalculator.Calculator.Calculation;

import com.example.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

import java.util.ArrayList;
import java.util.List;


public class CalculationImpl implements Calculation {

    private String query;
    private CalculationType currentCalculationType;

    public CalculationImpl(String query) {
        this.query = query;
    }

        @Override
        public Calculation calculate(CalculationType type) {

        this.currentCalculationType = type;

        Integer lastOperatorIndex = 0;
        List<OperatorTracker> operatorTrackers = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            Character currentCharacter = query.charAt(i);

            type = divisionAndMultiplicationHasSamePriority(currentCharacter);

            if (isCharacterTheCurrentOperatorType(currentCharacter)) {

                operatorTrackers.add(new OperatorTracker(lastOperatorIndex, i));

                lastOperatorIndex = i + 1;

                    for (int j = i + 1; j < query.length(); j++) {

                    char nestedCharacter = query.charAt(j);

                    if (type.isCharacterAnOperator(nestedCharacter)) {
                        operatorTrackers.add(new OperatorTracker(lastOperatorIndex, j));
                        lastOperatorIndex = j + 1;
                        j = query.length();
                    }
                }

            } else if (type.isCharacterAnOperator(currentCharacter)) {
                lastOperatorIndex = i + 1;
            }

            if (isEndOfString(i)) {
                operatorTrackers.add(new OperatorTracker(lastOperatorIndex, i + 1));
            }

            if (isOperatorsResolvable(operatorTrackers)) {

                this.resolveCalculation(operatorTrackers);

                lastOperatorIndex = 0;
                i = 0;
                operatorTrackers.clear();
            }
        }

        return this;
    }

    private boolean isOperatorsResolvable(List<OperatorTracker> operatorTrackers) {
        return operatorTrackers.size() == 2;
    }

    private boolean isEndOfString(int i) {
        return i == query.length() - 1;
    }

    private boolean isCharacterTheCurrentOperatorType(Character currentCharacter) {
        return currentCharacter == currentCalculationType.getOperatorType();
    }

    private CalculationType divisionAndMultiplicationHasSamePriority(Character currentCharacter) {
        if (currentCalculationType == CalculationType.DIVISION || currentCalculationType == CalculationType.MULTIPLICATION) {

        if(currentCharacter == CalculationType.DIVISION.getOperatorType() ||currentCharacter == CalculationType.MULTIPLICATION.getOperatorType() ) {
        currentCalculationType = CalculationType.getTypeDynamicly(currentCharacter);
        }
    }
        return currentCalculationType;
    }

    private void resolveCalculation(List<OperatorTracker> trackers) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Number number1 = Double.valueOf(query.substring(trackers.get(0).getIndexStart(), trackers.get(0).getIndexEnd()));
        Number number2 = Double.valueOf(query.substring(trackers.get(1).getIndexStart(), trackers.get(1).getIndexEnd()));

        String tmp = String.valueOf(currentCalculationType.calculate(number1.doubleValue(), number2.doubleValue()));

        stringBuilder.replace(trackers.get(0).getIndexStart(), trackers.get(1).getIndexEnd(), tmp);
        query = stringBuilder.toString();

         this.query = query;
    }

    private boolean isDouble(Number number) {
        if ((number.doubleValue() % 1) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getResult() {
        Number result = Double.valueOf(query);
        if (isDouble(result)) {
            return String.valueOf(result.doubleValue());
        } else {
            return String.valueOf(result.longValue());
        }
    }
}
