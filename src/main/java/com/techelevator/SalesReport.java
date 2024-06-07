package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class SalesReport {
    private static final String SALES_REPORT_FILE = "SalesReport.txt";

    public static void generateSalesReport(TreeMap<String, Item> itemsMap) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SALES_REPORT_FILE))) {
            double totalSales = 0;
            for (Item item : itemsMap.values()) {
                writer.println(item.getItemName() + "|" + item.getSales());
                totalSales += item.getSales() * item.getItemPrice();
            }
            writer.println("\nTOTAL SALES $" + totalSales);
        } catch (IOException e) {
            System.out.println("Error generating sales report: " + e.getMessage());
        }
    }
}
