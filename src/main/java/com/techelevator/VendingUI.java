package com.techelevator;

import java.util.Map;
import java.util.Scanner;


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
            scanner.nextLine();

            if (purchaseChoice == 1) {
                System.out.print("Enter the amount to feed (whole dollars only): ");
                int amountToFeed = scanner.nextInt();
                scanner.nextLine();
                cashRegister.addMoney(amountToFeed);
                System.out.println("Money added: $" + amountToFeed);

            } else if (purchaseChoice == 2) {
                System.out.print("Enter the slot location to select a product: ");
                String slotLocation = scanner.nextLine().trim(); // Trim the input
                Item selectedProduct = inventory.getItem(slotLocation);

                if (selectedProduct != null) {

                    if (selectedProduct.getQuantity() > 0 && cashRegister.getCurrentBalance() >= selectedProduct.getPrice()) {
                        cashRegister.subtractMoney(selectedProduct.getPrice());
                        selectedProduct.decreaseQuantity();
                        System.out.println(selectedProduct.getName() + " dispensed.");

                        if (selectedProduct.getType().equals("Chip")) {
                            System.out.println("Crunch Crunch, Yum!");

                        } else if (selectedProduct.getType().equals("Candy")) {
                            System.out.println("Munch Munch, Yum!");

                        } else if (selectedProduct.getType().equals("Drink")) {
                            System.out.println("Glug Glug, Yum!");

                        } else if (selectedProduct.getType().equals("Gum")) {
                            System.out.println("Chew Chew, Yum!");
                        }
                    } else {

                        if (selectedProduct.getQuantity() == 0) {
                            System.out.println("Selected product is SOLD OUT.");

                        } else {
                            System.out.println("Insufficient funds.");
                        }
                    }

                } else {
                    System.out.println("Invalid slot location.");
                }

            } else if (purchaseChoice == 3) {
                purchaseInProgress = false;
                System.out.println("Finishing transaction...");
                int changeAmount = cashRegister.returnChange();
                System.out.println("Change returned: $" + changeAmount);

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}





