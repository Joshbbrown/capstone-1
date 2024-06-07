package com.techelevator;

public class Item {
    private String itemName;
    private double itemPrice;
    private String itemType;
    private int itemQuantity;
    private int sales;
    private int initialQuantity;
    public Item(String itemName, double itemPrice, String itemType) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.itemQuantity = 10; // Set quantity to 10
        this.sales = 0;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getSales() {
        return sales;
    }

    public void incrementSales() {
        this.sales++;
    }

    public void decrementQuantity() {
        if (itemQuantity > 0) {
            itemQuantity--;
        }
    }


}


