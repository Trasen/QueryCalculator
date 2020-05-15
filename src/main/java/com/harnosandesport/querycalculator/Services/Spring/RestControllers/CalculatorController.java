package com.harnosandesport.querycalculator.Services.Spring.RestControllers;

import com.harnosandesport.querycalculator.Calculator.Calculator;
import com.harnosandesport.querycalculator.Calculator.CalculatorImpl3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/calculator")
public class CalculatorController {

    @GET
    public String calculator(@QueryParam("query") String query) {

        Calculator calculator = new CalculatorImpl3();
        //Using the request queryString seems to be the only way for SpringBoot to allow '+' signs to be sent. Query will filter this away.
        //String pureQuery = request.getQueryString();
        //pureQuery = pureQuery.replace("pwr", "^");
        System.out.println(query);
        return calculator.calculate(query);
    }
}