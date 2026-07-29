package com.ashokit;

public class ATM {

    private Printer printer;
    public ATM(){
        System.out.println("ATM() no arg constructor called..");
    }
    public ATM(Printer printer){
        this.printer=printer;
        System.out.println("ATM(printer) parameterized constructor called..");
    }

    public void withdraw(int amount){
        System.out.println("Withdraw successfully...");
        printer.print();
    }

}
