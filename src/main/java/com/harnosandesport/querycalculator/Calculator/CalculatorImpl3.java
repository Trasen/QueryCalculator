package com.harnosandesport.querycalculator.Calculator;

import com.harnosandesport.querycalculator.Calculator.Calculation.Calculation;
import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationImpl;
import com.harnosandesport.querycalculator.Calculator.Calculation.CalculationTypes.CalculationType;
import com.harnosandesport.querycalculator.Calculator.Calculation.OperatorTracker;

public class CalculatorImpl3 implements Calculator {


@Override
public String calculate(String query) {

        query = removeUnsupportedCharacters(query);

        query = dealWithNestedCalculations(query);

        query = query.replaceAll("[^0-9*-/+^]", "");

        return doCalculation(query);
}

        private String removeUnsupportedCharacters(String query) {
                query = query.replaceAll("[^0-9*-/+^()]", "");
                return query;
        }

        private String dealWithNestedCalculations(String query) {
                OperatorTracker tracker;

                do {
                        tracker = findNestedCalculations(query);

                        if (tracker != null) {

                                String result = doCalculation(query.substring(tracker.getIndexStart(), tracker.getIndexEnd()));

                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(query);
                                stringBuilder.replace(tracker.getIndexStart() - 1, tracker.getIndexEnd() + 1, result);
                                query = stringBuilder.toString();
                        }
                } while (tracker != null);
                return query;
        }

        private OperatorTracker findNestedCalculations(String query) {

                OperatorTracker tracker = new OperatorTracker();
                for (int i = 0; i < query.length(); i++) {

                        Character ch = query.charAt(i);

                        if (ch == '(') {
                                tracker.setIndexStart(i + 1);
                        }

                        if (ch == ')') {
                                tracker.setIndexEnd(i);
                                return tracker;
                        }

                        if(i == query.length()-1 && tracker.getIndexEnd() == null) {
                                tracker.setIndexEnd(i);
                        }
                }
                return null;
        }

        private String doCalculation(String query) {

                Calculation calculation = new CalculationImpl(query);

                calculation.run(CalculationType.POWEROF)
                        .run(CalculationType.MULTIPLICATION)
                        .run(CalculationType.ADDITION)
                        .run(CalculationType.SUBSTRACTION);

                return calculation.getResult();
        }

}