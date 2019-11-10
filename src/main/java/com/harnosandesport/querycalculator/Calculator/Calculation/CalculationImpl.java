package com.harnosandesport.querycalculator.Calculator.Calculation;

import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CalculationImpl implements Calculation {

    private String query;
    private CalculationType currentCalculationType;

    public CalculationImpl(String query) {
        this.query = query;
    }

    public List<OperatorTracker> findExpression(CalculationType type) {

        currentCalculationType = type;
        List<OperatorTracker> trackers = new ArrayList<>();

        for(int i = 0; i < query.length(); i++) {

            Character ch = query.charAt(i);

            if(isCharacterTheCurrentOperatorType(ch)) {
                if(trackers.isEmpty()) {
                trackers.add(new OperatorTracker(0, i));
                } else {
                trackers.add(new OperatorTracker(trackers.get(0).getIndexEnd(), i));
                }
            }

            if(isAnOperatorButNotTheCurrentOne(type, ch)) {
                trackers.add(new OperatorTracker(trackers.get(0).getIndexEnd() + 1, i));
            }

            if(isEndOfString(i)) {
                trackers.add(new OperatorTracker(trackers.get(2).getIndexEnd(), i));
            }

            if(trackers.size() == 2) {
                return trackers;
            }
        }
        return null;
    }

    private boolean isAnOperatorButNotTheCurrentOne(CalculationType type, Character ch) {
        return CalculationType.isCharacterAnOperator(ch) && ch != type.getOperatorType();
    }

    @Override
        public Calculation run(CalculationType type) {

        this.currentCalculationType = type;

        Integer lastOperatorIndex = 0;
        List<OperatorTracker> operatorTrackers = new ArrayList<>();

            for (int i = 0; i < query.length(); i++) {

                Character currentCharacter = query.charAt(i);

                type = divisionAndMultiplicationHasSamePriority(currentCharacter);
                type = additionAndSubstrationHasSamePriority(currentCharacter);

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

    private CalculationType additionAndSubstrationHasSamePriority(Character currentCharacter) {
        if (currentCalculationType == CalculationType.ADDITION || currentCalculationType == CalculationType.SUBSTRACTION) {

            if(currentCharacter == CalculationType.ADDITION.getOperatorType() ||currentCharacter == CalculationType.SUBSTRACTION.getOperatorType() ) {
                currentCalculationType = CalculationType.getTypeDynamicly(currentCharacter);
            }
        }
        return currentCalculationType;
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

        BigDecimal number1 = new BigDecimal(query.substring(trackers.get(0).getIndexStart(), trackers.get(0).getIndexEnd()));
        BigDecimal number2 = new BigDecimal(query.substring(trackers.get(1).getIndexStart(), trackers.get(1).getIndexEnd()));

        String tmp = String.valueOf(currentCalculationType.calculate(number1, number2));

        stringBuilder.replace(trackers.get(0).getIndexStart(), trackers.get(1).getIndexEnd(), tmp);
        query = stringBuilder.toString();
        System.out.println(query);
    }

    private boolean isDouble(BigDecimal number) {
        if ((number.doubleValue() % 1) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getResult() {
         return new BigDecimal(query).toEngineeringString();


        /*if (isDouble(result)) {
            return result.toPlainString();
        } else {
            return result.toPlainString();
        } */
    }
}
