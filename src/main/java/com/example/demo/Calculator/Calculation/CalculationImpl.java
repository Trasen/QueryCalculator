package com.example.demo.Calculator.Calculation;

import com.example.demo.Calculator.Calculation.CalculationTypes.CalculationType;

import java.util.ArrayList;
import java.util.List;


public class CalculationImpl implements Calculation {

    @Override
        public String calculate(String query, CalculationType type) {

        Integer lastOperatorIndex = 0;
        List<OperatorTracker> operatorTrackers = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            char currentCharacter = query.charAt(i);

            if (currentCharacter == type.getOperatorType()) {
                operatorTrackers.add(new OperatorTracker(lastOperatorIndex, i));
                lastOperatorIndex = i + 1;

                for (int j = i + 1; j < query.length(); j++) {

                    char nestedCharacter = query.charAt(j);

                    if (type.containsOperator(nestedCharacter)) {
                        operatorTrackers.add(new OperatorTracker(lastOperatorIndex, j));
                        lastOperatorIndex = j + 1;
                        j = query.length();
                    }
                }

            } else if (type.containsOperator(currentCharacter)) {
                lastOperatorIndex = i + 1;
            }

            if (i == query.length() - 1) {
                operatorTrackers.add(new OperatorTracker(lastOperatorIndex, i + 1));
            }

            if (operatorTrackers.size() == 2) {

                query = this.resolveCalculation(operatorTrackers, query, type);

                lastOperatorIndex = 0;
                i = 0;
                operatorTrackers.clear();
            }

        }

        return query;
    }

    private String resolveCalculation(List<OperatorTracker> trackers, String query, CalculationType type) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Number number1 = Double.valueOf(query.substring(trackers.get(0).getIndexStart(), trackers.get(0).getIndexEnd()));
        Number number2 = Double.valueOf(query.substring(trackers.get(1).getIndexStart(), trackers.get(1).getIndexEnd()));

        String tmp = String.valueOf(type.calculate(number1.doubleValue(), number2.doubleValue()));

        stringBuilder.replace(trackers.get(0).getIndexStart(), trackers.get(1).getIndexEnd(), tmp);
        query = stringBuilder.toString();

        return query;
    }
}
