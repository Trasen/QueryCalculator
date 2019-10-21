package com.example.demo.RestControllers;

import com.example.demo.Calculator.Calculator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String calculator(@RequestParam(value = "query", defaultValue = "0") String query, HttpServletRequest request) {

        Calculator calculator = new Calculator();

        return calculator.calculate(request.getQueryString());

    }
}