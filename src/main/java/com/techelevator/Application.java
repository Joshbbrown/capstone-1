package com.techelevator;

import java.util.Scanner;

public class Application {
	private static final String INVENTORY_FILE = "vendingmachine.csv";

	public static void main(String[] args) {
		VendingUI vendingUI = new VendingUI();
		Inventory inventory = new Inventory();
		TheFileReader.loadInventory(INVENTORY_FILE, inventory);
		CashRegister cashRegister = new CashRegister();

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			vendingUI.displayMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			if (choice == 1) {
				vendingUI.displayInventory(inventory);

			} else if (choice == 2) {
				vendingUI.handlePurchase(inventory, cashRegister, scanner);

			} else if (choice == 3) {
				exit = true;

			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}