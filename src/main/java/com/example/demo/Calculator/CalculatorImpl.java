package com.example.demo.Calculator;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class CalculatorImpl implements Calculator {

    @Override
    public String calculate(String query) {

        String filteredQuery = query.replaceAll(" ", "").replaceAll("[^0-9.+*]", "");

        List<Double> additions = new ArrayList<>();
        List<Double> multiplication = new ArrayList<>();

        String previousOperator = "";
        String valueConstructor = "";

        Double addition = 0D;

        for (int i = 0; i < filteredQuery.length(); i++) {

            String character = String.valueOf(filteredQuery.charAt(i));

            switch (character) {

                case ".":
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":

                    valueConstructor += character;

                    if (previousOperator.matches("\\+") && i == filteredQuery.length() - 1) {
                        additions.add(Double.valueOf(valueConstructor));
                    }

                    if (previousOperator.matches("\\*") && i == filteredQuery.length() - 1) {
                        multiplication.add(Double.valueOf(valueConstructor));
                    }

                    continue;

                case "+":

                    previousOperator = "+";
                    additions.add(Double.valueOf(valueConstructor));
                    valueConstructor = "";
                    break;

                case "*":

                    previousOperator = "*";
                    multiplication.add(Double.valueOf(valueConstructor));
                    valueConstructor = "";
                    break;

            }
        }

        for (int i = 0; i < additions.size(); i++) {
            System.out.println(additions.get(i));
            addition += additions.get(i);
        }

        Double tmpMult = 0D;

        for (int i = 0; i < multiplication.size(); i++) {

            if (i == 0) {
                tmpMult += multiplication.get(i) * multiplication.get(i + 1);
                i = 1;
            } else {
                tmpMult = tmpMult * multiplication.get(i);
            }
        }

        addition += tmpMult;

        Number returnValue = addition;

        if (isDouble(returnValue)) {
            return String.valueOf(returnValue.doubleValue());
        } else {
            return String.valueOf(returnValue.longValue());

        }
    }

    private boolean isDouble(Number number) {

        if ((number.doubleValue() % 1) == 0) {
            return false;
        } else {
            return true;

        }
    }
}
