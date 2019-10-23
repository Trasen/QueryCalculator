package com.example.demo.Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl2 implements Calculator {

    @Override
    public String calculate(String query) {

        query = this.calculateDivision(query);
        query = this.calculateMultiplication(query);
        query = this.calculateAddition(query);


        Number result = Double.valueOf(query);

        if (this.isDouble(result)) {
            return String.valueOf(result.doubleValue());
        } else {
            return String.valueOf(result.longValue());
        }
    }

    private String calculateDivision(String query) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Integer lastDividerIndex = 0;
        List<DividerTracker> indexTracker = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            char currentCharacter = query.charAt(i);

            switch (currentCharacter) {

                case '/':
                    indexTracker.add(new DividerTracker(lastDividerIndex, i));
                    lastDividerIndex = i + 1;

                    for (int j = i + 1; j < query.length(); j++) {
                        char nestedCharacter = query.charAt(j);
                        switch (nestedCharacter) {

                            case '+':
                            case '*':
                            case '/':
                                indexTracker.add(new DividerTracker(lastDividerIndex, j));
                                lastDividerIndex = j + 1;
                                j = query.length();
                        }

                    }
                    break;
            }

            if (i == query.length() - 1) {
                indexTracker.add(new DividerTracker(lastDividerIndex, i + 1));
            }

            if (indexTracker.size() == 2) {
                Number number1 = Double.valueOf(query.substring(indexTracker.get(0).indexStart, indexTracker.get(0).indexEnd));
                Number number2 = Double.valueOf(query.substring(indexTracker.get(1).indexStart, indexTracker.get(1).indexEnd));

                String tmp = String.valueOf(number1.doubleValue() / number2.doubleValue());

                stringBuilder.replace(indexTracker.get(0).indexStart, indexTracker.get(1).indexEnd, tmp);
                query = stringBuilder.toString();
                System.out.println(query);

                lastDividerIndex = 0;
                i = 0;
                indexTracker.clear();
            }

        }

        return query;
    }


    private String calculateMultiplication(String query) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Integer lastDividerIndex = 0;
        List<DividerTracker> indexTracker = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            char currentCharacter = query.charAt(i);

            switch (currentCharacter) {

                case '*':
                    indexTracker.add(new DividerTracker(lastDividerIndex, i));
                    lastDividerIndex = i + 1;

                    for (int j = i + 1; j < query.length(); j++) {
                        char nestedCharacter = query.charAt(j);
                        switch (nestedCharacter) {

                            case '+':
                            case '*':
                            case '/':
                                indexTracker.add(new DividerTracker(lastDividerIndex, j));
                                lastDividerIndex = j + 1;
                                j = query.length();
                        }

                    }
                    break;
            }

            if (i == query.length() - 1) {
                indexTracker.add(new DividerTracker(lastDividerIndex, i + 1));
            }

            if (indexTracker.size() == 2) {
                Number number1 = Double.valueOf(query.substring(indexTracker.get(0).indexStart, indexTracker.get(0).indexEnd));
                Number number2 = Double.valueOf(query.substring(indexTracker.get(1).indexStart, indexTracker.get(1).indexEnd));

                String tmp = String.valueOf(number1.doubleValue() * number2.doubleValue());

                stringBuilder.replace(indexTracker.get(0).indexStart, indexTracker.get(1).indexEnd, tmp);
                query = stringBuilder.toString();
                System.out.println(query);

                lastDividerIndex = 0;
                i = 0;
                indexTracker.clear();
            }

        }

        return query;
    }

    private String calculateAddition(String query) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(query);

        Integer lastDividerIndex = 0;
        List<DividerTracker> indexTracker = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {

            char currentCharacter = query.charAt(i);

            switch (currentCharacter) {

                case '+':
                    indexTracker.add(new DividerTracker(lastDividerIndex, i));
                    lastDividerIndex = i + 1;

                    for (int j = i + 1; j < query.length(); j++) {
                        char nestedCharacter = query.charAt(j);
                        switch (nestedCharacter) {

                            case '+':
                            case '*':
                            case '/':
                                indexTracker.add(new DividerTracker(lastDividerIndex, j));
                                lastDividerIndex = j + 1;
                                j = query.length();
                        }

                    }
                    break;
            }

            if (i == query.length() - 1) {
                indexTracker.add(new DividerTracker(lastDividerIndex, i + 1));
            }

            if (indexTracker.size() == 2) {
                Number number1 = Double.valueOf(query.substring(indexTracker.get(0).indexStart, indexTracker.get(0).indexEnd));
                Number number2 = Double.valueOf(query.substring(indexTracker.get(1).indexStart, indexTracker.get(1).indexEnd));

                String tmp = String.valueOf(number1.doubleValue() + number2.doubleValue());

                stringBuilder.replace(indexTracker.get(0).indexStart, indexTracker.get(1).indexEnd, tmp);
                query = stringBuilder.toString();
                System.out.println(query);

                lastDividerIndex = 0;
                i = 0;
                indexTracker.clear();
            }

        }

        return query;
    }

    private boolean isDouble(Number number) {

        if ((number.doubleValue() % 1) == 0) {
            return false;
        } else {
            return true;

        }
    }
}

    class DividerTracker {

        int indexStart;
        int indexEnd;

        public DividerTracker(int indexStart, int indexEnd) {
            this.indexStart = indexStart;
            this.indexEnd = indexEnd;
        }
    }

