package com.harnosandesport.querycalculator.Services.Terminal;

import com.harnosandesport.querycalculator.Calculator.Calculator;
import com.harnosandesport.querycalculator.Calculator.CalculatorImpl3;
import com.harnosandesport.querycalculator.Services.StartService;

import java.util.Scanner;


public class Terminal implements StartService {

public void run(String[] args) {

		Calculator calculator = new CalculatorImpl3();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a calculation: ");
		String query = scanner.nextLine();

		System.out.println(calculator.calculate(query));
		}
}