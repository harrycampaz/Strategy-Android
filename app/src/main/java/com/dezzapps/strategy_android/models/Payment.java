package com.dezzapps.strategy_android.models;

public class Payment {

    private Strategy strategy;

    public  Payment(Strategy s){
        this.strategy = s;
    }

    public  String employStrategy(float f){
        return  this.strategy.processPayment(f);
    }
}
