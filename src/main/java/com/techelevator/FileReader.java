package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader extends Inventory {
    public void Inventory() {
        TreeMap<String,Inventory>  treeMap = new TreeMap<>();
    }

//    public FileReader(CashRegister cashRegister, Inventory inventory) {
//        super(cashRegister, inventory);
//    }

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
                    getItemsMap().put(slotLocation, item);
                } else {
                    System.out.println("Invalid line in input file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }





    // private static final String VENDING_MACHINE_FILE = "vendingmachine.csv";

}
