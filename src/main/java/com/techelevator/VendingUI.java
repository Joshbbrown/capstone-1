package com.techelevator;

import java.util.Map;
import java.util.Scanner;

// VendingUI.java
public class VendingUI {
    public void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayInventory(Inventory inventory) {
        System.out.println("\nVending Machine Inventory:");
        System.out.println("Slot Location  |  Name             |  Price  |  Quantity");
        System.out.println("---------------------------------------------------------");
        for (Map.Entry<String, Item> entry : inventory.getItems().entrySet()) {
            Item item = entry.getValue();
            String slotLocation = entry.getKey();
            String name = item.getName();
            double price = item.getPrice();
            int quantity = item.getQuantity();
            String quantityDisplay = (quantity > 0) ? String.valueOf(quantity) : "SOLD OUT";
            System.out.printf("%-14s | %-18s | $%-5.2f | %s%n", slotLocation, name, price, quantityDisplay);
        }
    }

    public void handlePurchase(Inventory inventory, CashRegister cashRegister, Scanner scanner) {
        boolean purchaseInProgress = true;

        while (purchaseInProgress) {
            System.out.println("\nPurchase Menu:");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.print("Enter your choice: ");
            int purchaseChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (purchaseChoice == 1) {
                System.out.print("Enter the amount to feed (whole dollars only): ");
                int amountToFeed = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                cashRegister.addMoney(amountToFeed);
                System.out.println("Money added: $" + amountToFeed);
            } else if (purchaseChoice == 2) {
                System.out.println("Select product functionality to be implemented.");
                // Implement select product functionality
            } else if (purchaseChoice == 3) {
                purchaseInProgress = false;
                System.out.println("Finishing transaction...");
                // Implement transaction finishing functionality (e.g., return change)
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            // Consume newline character after each input
            scanner.nextLine();
        }
    }
}





