package com.harnosandesport.querycalculator.RestControllers;

import com.harnosandesport.querycalculator.Calculator.Calculator;
import com.harnosandesport.querycalculator.Calculator.CalculatorImpl3;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String calculator(@RequestParam(value = "query", defaultValue = "0") String query, HttpServletRequest request) {

        Calculator calculator = new CalculatorImpl3();
        //Using the request queryString seems to be the only way for SpringBoot to allow '+' signs to be sent. Query will filter this away.
        String pureQuery = request.getQueryString();
        pureQuery = pureQuery.replace("pwr", "^");
        System.out.println(pureQuery);
        return calculator.calculate(pureQuery);
    }
}