package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {
    private TreeMap<String, Item> itemsMap;

    public Item getItemBySlot(String slotLocation) {
        return itemsMap.get(slotLocation);
    }
    public Inventory() {
        itemsMap = new TreeMap<>();
    }

    public void loadItemsFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 4) { // Ensure valid format
                    String slotLocation = parts[0];
                    String itemName = parts[1];
                    double itemPrice = Double.parseDouble(parts[2]);
                    String itemType = parts[3];
                    Item item = new Item(itemName, itemPrice, itemType);
                    itemsMap.put(slotLocation, item);
                } else {
                    System.out.println("Invalid line in input file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public TreeMap<String, Item> getItemsMap() {
        return itemsMap;
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Map.Entry<String, Item> entry : itemsMap.entrySet()) {
            Item item = entry.getValue();
            int quantitySold = item.getInitialQuantity() - item.getItemQuantity();
            double itemSales = quantitySold * item.getItemPrice();
            totalSales += itemSales;
        }
        return totalSales;
    }


}
