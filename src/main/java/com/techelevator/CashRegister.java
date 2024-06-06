package com.techelevator;

public class CashRegister extends Application {
    private double balance;
    private  int deposit;
    private double purchase;

    public CashRegister(double balance, int deposit, double purchase) {
        this.balance = balance;
        this.deposit = deposit;
        this.purchase = purchase;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }
}
