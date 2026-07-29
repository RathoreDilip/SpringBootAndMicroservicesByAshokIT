package com.ashokit.runners.beans.life;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// bean life cycle

@Component
public class ReportService {
    public ReportService(){
        System.out.println("ReportService() constructor called .. bean is created...");
    }

    // after object creation then execute
    @PostConstruct
    public void init(){
        System.out.println("ReportService() - init() called...");
    }

    // before removing your object from ioc container then execute
    @PreDestroy
    public void destroy(){
        System.out.println("ReportService() - destroy() called...");
    }

}
