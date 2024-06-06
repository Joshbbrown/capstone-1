package com.techelevator;

import java.util.Scanner;

public class VendingUI {
    private Scanner myScanner = new Scanner(System.in);


    //Main Menu
    public String displayMainMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3)Exit");

        return myScanner.nextLine();

    }
    public String displayInventory() {
        System.out.println(getClass());
        return myScanner.nextLine();
    }




        // Aux menu
    public String displayPurchaseMenu() {
        System.out.println("\n (1) Feed Money");
        System.out.println(" (2) Make a Selection");
        System.out.println(" (3) Finish Transaction");
        // System.out.println("\n (4) Current Money Provided: $" + currentBalance);

        return myScanner.nextLine();

    }

    public String displayCashRegister() {
        System.out.println("work");
        return myScanner.nextLine();
    }
    }

