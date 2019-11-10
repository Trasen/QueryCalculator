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

            if(isEndOfExpression(i)) {
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

            for (int characterPositionInString = 0; characterPositionInString < query.length(); characterPositionInString++) {

                Character currentCharacter = query.charAt(characterPositionInString);

                type = samePriorityCalculations(currentCharacter);

                if (isCharacterTheCurrentOperatorType(currentCharacter)) {

                    operatorTrackers.add(new OperatorTracker(lastOperatorIndex, characterPositionInString));

                    lastOperatorIndex = characterPositionInString + 1;

                    for (int j = characterPositionInString + 1; j < query.length(); j++) {

                        char nestedCharacter = query.charAt(j);

                        if (type.isCharacterAnOperator(nestedCharacter)) {
                            operatorTrackers.add(new OperatorTracker(lastOperatorIndex, j));
                            lastOperatorIndex = j + 1;
                            j = query.length();
                        }
                    }

                } else if (type.isCharacterAnOperator(currentCharacter)) {
                    lastOperatorIndex = characterPositionInString + 1;
                }

                if (isEndOfExpression(characterPositionInString)) {
                    operatorTrackers.add(new OperatorTracker(lastOperatorIndex, characterPositionInString + 1));
                }

                if (isOperatorsResolvable(operatorTrackers)) {

                    this.resolveCalculation(operatorTrackers);

                    lastOperatorIndex = 0;
                    characterPositionInString = 0;
                    operatorTrackers.clear();
                }
            }

        return this;
    }

    private boolean isOperatorsResolvable(List<OperatorTracker> operatorTrackers) {
        return operatorTrackers.size() == 2;
    }

    private boolean isEndOfExpression(int i) {
        return i == query.length() - 1;
    }

    private boolean isCharacterTheCurrentOperatorType(Character currentCharacter) {
        return currentCharacter == currentCalculationType.getOperatorType();
    }

    private CalculationType samePriorityCalculations(Character currentCharacter) {

        samePriorityCalculation(currentCharacter, CalculationType.DIVISION, CalculationType.MULTIPLICATION);
        samePriorityCalculation(currentCharacter, CalculationType.ADDITION, CalculationType.SUBSTRACTION);

        return currentCalculationType;
    }

    private void samePriorityCalculation(Character currentCharacter, CalculationType firstType, CalculationType secondType) {
        if (currentCalculationType == firstType || currentCalculationType == secondType) {

            if (currentCharacter == firstType.getOperatorType() || currentCharacter == secondType.getOperatorType()) {
                currentCalculationType = CalculationType.getTypeDynamically(currentCharacter);
            }
        }
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

    @Override
    public String getResult() {
         return new BigDecimal(query).toEngineeringString();
    }
}
