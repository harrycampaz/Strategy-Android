package com.dezzapps.strategy_android.models;

public class Cash implements Strategy {
    @Override
    public String processPayment(float price) {
        return String.format("%.2f",price);
    }
}
