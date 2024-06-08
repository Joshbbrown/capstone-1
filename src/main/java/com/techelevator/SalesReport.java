package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

// SalesReport.java
public class SalesReport {
    private static final String REPORT_FILE_PREFIX = "SalesReport_";
    private static final String REPORT_FILE_SUFFIX = ".txt";
    private static final String DATE_FORMAT = "yyyyMMdd_HHmmss";

    public static void generateSalesReport(Map<String, Integer> salesData, Inventory inventory) {
        String timestamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        String reportFilename = REPORT_FILE_PREFIX + timestamp + REPORT_FILE_SUFFIX;

        try (PrintWriter writer = new PrintWriter(new FileWriter(reportFilename))) {
            for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
                String itemName = entry.getKey();
                int quantitySold = entry.getValue();
                writer.println(itemName + "|" + quantitySold);
            }
            writer.println("\nTOTAL SALES $" + calculateTotalSales(salesData, inventory));
        } catch (IOException e) {
            System.err.println("Error writing sales report: " + e.getMessage());
        }
    }

    private static double calculateTotalSales(Map<String, Integer> salesData, Inventory inventory) {
        double totalSales = 0;
        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            Item item = inventory.getItem(entry.getKey());
            totalSales += item.getPrice() * entry.getValue();
        }
        return totalSales;
    }
}
