package com.techelevator;

public class CashRegister {
    private double balance;
    private int balanceInCents;

    public CashRegister() {

    }

    // Constructor and other methods...

    public double returnChange() {
        double remainingBalanceInCents = balanceInCents;
        double quarters = remainingBalanceInCents  / .25;
        remainingBalanceInCents %= .25;
        double dimes = remainingBalanceInCents / .10;
        remainingBalanceInCents %= .10;
        double nickels = remainingBalanceInCents  / .5;

        // Calculate total change amount in dollars
        double totalChangeInDollars = ((quarters * .25) + (dimes * .10) + (nickels * .5)) / 100;

        // Reset balance
        balanceInCents = 0;

        return totalChangeInDollars;
    }

    public CashRegister(double balance) {
        this.balance = balance;
        this.balanceInCents = (int) (balance * 100); // Convert balance to cents
    }

    public void addMoney(double amount) {
        balance += amount;
        balanceInCents += amount * 100; // Convert added amount to cents and add to balanceInCents
    }

    public void subtractMoney(double amount) {
        balance -= amount;
        balanceInCents -= amount * 100; // Convert subtracted amount to cents and subtract from balanceInCents
    }

    public double getBalance() {
        return balance;
    }
}

