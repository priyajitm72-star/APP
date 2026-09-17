package com.banking;

import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.SavingsAccount;
import com.banking.payments.CardPayment;
import com.banking.payments.UPIPayment;

public class Main {
    public static void main(String[] args) {
        // Create instances of accounts
        Account savingsAccount = new SavingsAccount("SA123", 1000.0, 0.05);
        Account currentAccount = new CurrentAccount("CA456", 2000.0, 500.0);

        // Display account details using runtime polymorphism
        savingsAccount.displayDetails();
        currentAccount.displayDetails();

        // Create payment instances
        UPIPayment upiPayment = new UPIPayment();
        CardPayment cardPayment = new CardPayment();

        // Process payments
        upiPayment.pay(150.0);
        cardPayment.pay(200.0);
    }
}