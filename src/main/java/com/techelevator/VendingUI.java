package com.techelevator;

import java.util.Scanner;

public class VendingUI {
    private Scanner myScanner = new Scanner(System.in);

    public String printMainMenu(){
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3)Exit");

        return myScanner.nextLine();

    }

    public String displayPurchaseMenu(double currentBalance){
        System.out.println("\n (1) Feed Money");
        System.out.println("\n (2) Make a Selection");
        System.out.println("\n (3) Finish Transaction");
        System.out.println("\n (4) Current Money Provided: $" + currentBalance);

        return myScanner.nextLine();

    }

}
