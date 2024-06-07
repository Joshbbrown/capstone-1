package com.techelevator;

import java.util.Map;
import java.util.Scanner;

import java.util.Scanner;
import java.util.TreeMap;

public class VendingUI {
    private Scanner scanner = new Scanner(System.in);
    private CashRegister cashRegister;
    private Inventory inventory;

    public VendingUI(CashRegister cashRegister, Inventory inventory) {
        this.cashRegister = cashRegister;
        this.inventory = inventory;
    }

    public VendingUI() {
        
    }

    // Main Menu
    public String displayMainMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        return scanner.nextLine();
    }

    public void handleMainMenuSelection(String choice) {
        switch (choice) {
            case "1":
                displayInventory();
                break;
            case "2":
                displayPurchaseMenu();
                break;
            case "3":
                System.out.println("Thank you, goodbye!");
                // Add code to exit the program gracefully
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Displaying Vending Machine Items:");
        TreeMap<String, Item> itemsMap = inventory.getItemsMap();
        for (Map.Entry<String, Item> entry : itemsMap.entrySet()) {
            String slotLocation = entry.getKey();
            Item item = entry.getValue();
            System.out.println(slotLocation + ": " + item.getItemName() + " - $" + item.getItemPrice() + " (" + item.getItemQuantity() + " available)");
        }
    }

    // Aux menu
    public void displayPurchaseMenu() {
        while (true) {
            System.out.println("\n (1) Feed Money");
            System.out.println(" (2) Make a Selection");
            System.out.println(" (3) Finish Transaction");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // Add code to handle feeding money
                    System.out.println("Enter amount to feed (whole dollars only): ");
                    int amount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    cashRegister.addMoney(amount);
                    System.out.println("Money added: $" + amount);
                    break;
                case "2":
                    // Add code to handle making a selection
                    System.out.println("Enter slot location to make a selection: ");
                    String slotLocation = scanner.nextLine();
                    Item item = inventory.getItemBySlot(slotLocation);
                    if (item == null) {
                        System.out.println("Invalid slot location. Please try again.");
                        break;
                    }
                    if (item.getItemQuantity() <= 0) {
                        System.out.println("Sorry, " + item.getItemName() + " is sold out.");
                        break;
                    }
                    if (cashRegister.getBalance() < item.getItemPrice()) {
                        System.out.println("Insufficient funds. Please feed more money.");
                        break;
                    }
                    // Process purchase
                    System.out.println("Dispensing " + item.getItemName() + "...");
                    System.out.println("Quantity: 1");
                    System.out.println("Cost: $" + item.getItemPrice());
                    System.out.println("Money remaining: $" + (cashRegister.getBalance() - item.getItemPrice()));
                    switch (item.getItemType()) {
                        case "Chip":
                            System.out.println("Crunch Crunch, Yum!");
                            break;
                        case "Candy":
                            System.out.println("Munch Munch, Yum!");
                            break;
                        case "Drink":
                            System.out.println("Glug Glug, Yum!");
                            break;
                        case "Gum":
                            System.out.println("Chew Chew, Yum!");
                            break;
                    }
                    item.decrementQuantity(); // Decrease item quantity
                    cashRegister.subtractMoney(item.getItemPrice()); // Deduct item price from balance
                    break;
                case "3":
                    // Finish transaction
                    int change = (int) cashRegister.returnChange();
                    System.out.println("Transaction complete. Change returned: $" + change);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void exit() {
    }
}



