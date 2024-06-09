package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CashRegister {

    private static Map<Integer, Integer> moneyStock;
    private static int balance = 0;




    public static void subtractMoney(double amount) {
        balance -= amount;
    }

    public static int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    public static int getCurrentBalance() {
        return balance;
    }
    public CashRegister() {
        moneyStock = new HashMap<>();
        moneyStock.put(1, 0); // Number of $1 bills
        moneyStock.put(5, 0); // Number of $5 bills
        moneyStock.put(10, 0); // Number of $10 bills
    }

    public static void addMoney(int amount) {
        if (amount == 1 || amount == 5 || amount == 10) {
            moneyStock.put(amount, moneyStock.get(amount) + 1);
        }
    }

    public Map<Integer, Integer> returnChange(double amount) {
        Map<Integer, Integer> change = new HashMap<>();
        BigDecimal changeAmount = BigDecimal.valueOf(amount);
        BigDecimal quarter = BigDecimal.valueOf(0.25);
        BigDecimal dime = BigDecimal.valueOf(0.10);
        BigDecimal nickel = BigDecimal.valueOf(0.05);

        int quarters = changeAmount.divide(quarter, 0, RoundingMode.DOWN).intValue();
        change.put(25, quarters);
        changeAmount = changeAmount.subtract(quarter.multiply(BigDecimal.valueOf(quarters)));

        int dimes = changeAmount.divide(dime, 0, RoundingMode.DOWN).intValue();
        change.put(10, dimes);
        changeAmount = changeAmount.subtract(dime.multiply(BigDecimal.valueOf(dimes)));

        int nickels = changeAmount.divide(nickel, 0, RoundingMode.DOWN).intValue();
        change.put(5, nickels);
        changeAmount = changeAmount.subtract(nickel.multiply(BigDecimal.valueOf(nickels)));

        return change;
    }
}

