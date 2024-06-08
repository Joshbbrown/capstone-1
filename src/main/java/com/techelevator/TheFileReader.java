package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TheFileReader {
    private String filename;

    public TheFileReader(String filename) {
        this.filename = filename;
    }

    public static void loadInventory(String inventoryFile, Inventory inventory) {
        try (BufferedReader reader = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String slotLocation = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String type = parts[3].trim();
                    Item item = new Item(name, price, type, 10); // Initial quantity set to 10
                    inventory.addItem(slotLocation, item);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
    }
}
