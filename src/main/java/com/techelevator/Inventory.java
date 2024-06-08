package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {
    private static Map<String, Item> items;

    public Inventory() {
        this.items = new TreeMap<>();
    }

    public void addItem(String slotLocation, Item item) {
        items.put(slotLocation, item);
    }

    public static Item getItem(String slotLocation) {
        return items.get(slotLocation);
    }

    public boolean isItemAvailable(String slotLocation) {
        Item item = items.get(slotLocation);
        return item != null && item.getQuantity() > 0;
    }

    public void updateQuantity(String slotLocation, int quantity) {
        Item item = items.get(slotLocation);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
