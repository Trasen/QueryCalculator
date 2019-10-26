package com.example.demo.Calculator.Calculation;

import com.example.demo.Calculator.Calculation.CalculationTypes.CalculationType;

import java.util.ArrayList;
import java.util.List;


public class CalculationImpl implements Calculation {

    @Override
        public String calculate(String query, CalculationType type) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Integer lastDividerIndex = 0;
        List<OperatorTracker> operatorTrackers = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            char currentCharacter = query.charAt(i);

            if (currentCharacter == type.getType()) {
                operatorTrackers.add(new OperatorTracker(lastDividerIndex, i));
                lastDividerIndex = i + 1;

                for (int j = i + 1; j < query.length(); j++) {

                    char nestedCharacter = query.charAt(j);

                    if (type.contains(nestedCharacter)) {
                        operatorTrackers.add(new OperatorTracker(lastDividerIndex, j));
                        lastDividerIndex = j + 1;
                        j = query.length();
                    }
                }

            } else if (type.contains(currentCharacter)) {
                lastDividerIndex = i + 1;
            }

            if (i == query.length() - 1) {
                operatorTrackers.add(new OperatorTracker(lastDividerIndex, i + 1));
            }

            if (operatorTrackers.size() == 2) {
                Number number1 = Double.valueOf(query.substring(operatorTrackers.get(0).getIndexStart(), operatorTrackers.get(0).getIndexEnd()));
                Number number2 = Double.valueOf(query.substring(operatorTrackers.get(1).getIndexStart(), operatorTrackers.get(1).getIndexEnd()));

                String tmp = String.valueOf(type.calculate(number1.doubleValue(), number2.doubleValue()));

                stringBuilder.replace(operatorTrackers.get(0).getIndexStart(), operatorTrackers.get(1).getIndexEnd(), tmp);
                query = stringBuilder.toString();

                lastDividerIndex = 0;
                i = 0;
                operatorTrackers.clear();
            }

        }

        return query;
    }
}
