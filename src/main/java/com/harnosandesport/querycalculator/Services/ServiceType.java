package com.harnosandesport.querycalculator.Services;

import com.harnosandesport.querycalculator.Services.Spring.Spring;
import com.harnosandesport.querycalculator.Services.Terminal.Terminal;

public enum ServiceType {

    SPRING("spring") {

        @Override
        StartService createService() {
            return new Spring();
        }
    },

    TERMINAL("terminal") {

        @Override
        StartService createService() {
            return new Terminal();
        }
    };

    private String type;

     ServiceType(String type) {
        this.type = type;
    }

    abstract StartService createService();

     public static StartService getStartServiceDynamically(String type) {
         return findStartService(type);
     }

    private static StartService findStartService(String type) {

         StartService startService = new Terminal();

        for(ServiceType t: ServiceType.values()) {
            if(t.type.equalsIgnoreCase(type)) {
                startService = t.createService();
            }
        }
        return startService;
    }
}
