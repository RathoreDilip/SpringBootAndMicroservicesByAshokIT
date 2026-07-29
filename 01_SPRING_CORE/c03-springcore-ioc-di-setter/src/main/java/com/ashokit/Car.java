package com.ashokit;
public class Car {
    private Engine engine;
    public Car(){
        System.out.println("Car() constructor called..");
    }
    public void setEngine(Engine engine) {
        System.out.println("setEngine() called..");
        this.engine = engine;
    }
    public void drive(){
        int start=engine.start();
        if(start==1)
            System.out.println("Journey has started...");
        else
            System.out.println("Engine problem..");
    }

}
