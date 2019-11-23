package com.harnosandesport.querycalculator;

import com.harnosandesport.querycalculator.Services.ServiceType;
import com.harnosandesport.querycalculator.Services.StartService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> arguments = Arrays.asList(args);

        StringBuilder builder = new StringBuilder();
        StartService startService = ServiceType.getStartServiceDynamically((arguments.size() != 0?arguments.get(1):""));
        startService.run(args);
    }
}