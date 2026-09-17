package com.banking.payments;

public class UPIPayment implements SecurePayment, OnlineTransaction {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }

    @Override
    public void verifyPayment() {
        System.out.println("Payment verified using UPI.");
    }
}