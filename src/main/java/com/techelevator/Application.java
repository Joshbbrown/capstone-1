package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Application extends VendingUI {
	private static final String VENDING_MACHINE_FILE = "vendingmachine.csv";
	private static final String SALES_REPORT_DIRECTORY = "sales_reports/";

	public Application(CashRegister cashRegister, Inventory inventory) {
		super(cashRegister, inventory);
	}

	public static void main(String[] args) {
		// Start cash register and inventory
		CashRegister cashRegister = new CashRegister(0); // Start with zero balance
		Inventory inventory = new Inventory();
		inventory.loadItemsFromFile(VENDING_MACHINE_FILE);

		// Start vending UI
		VendingUI vendingUI = new VendingUI();

		while (true) {
			String choice = vendingUI.displayMainMenu();
			if (choice.equals("1")) {
				vendingUI.displayInventory();
			} else if (choice.equals("2")) {
				vendingUI.displayPurchaseMenu();
			} else if (choice.equals("3")) {
				vendingUI.exit();
				return;
			} else if (choice.equals("4")) {
				generateSalesReport(inventory);
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void generateSalesReport(Inventory inventory) {
		// Create file name using current date and time
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String fileName = SALES_REPORT_DIRECTORY + "sales_report_" + now.format(formatter) + ".txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			// Write header
			writer.println("Sales report");

			// Go through the items in the inventory and write sales
			for (Map.Entry<String, Item> entry : inventory.getItemsMap().entrySet()) {
				Item item = entry.getValue();
				int quantitySold = item.getInitialQuantity() - item.getItemQuantity();
				writer.println(item.getItemName() + "|" + quantitySold);
			}

			//  Total sales
			double totalSales = inventory.calculateTotalSales();

			// Write total sales
			writer.println("\n**TOTAL SALES** $" + totalSales);

			System.out.println("Sales report generated: " + fileName);
		} catch (IOException e) {
			System.out.println("Error generating sales report: " + e.getMessage());
		}
	}
}