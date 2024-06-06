package com.techelevator;

import org.junit.Before;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
		@Before
	public void run() {
		VendingUI ui = new VendingUI();

		//do amazing stuff here!
		while (true) {
			String userChoice = ui.displayMainMenu();
			if (userChoice.equals("1")) {
				ui.displayInventory();



			} else if (userChoice.equals("2")) {
				ui.displayPurchaseMenu();
				//TODO: needs to print the aux menu and we need to make it loop in their//



			} else if (userChoice.equals("3")){
				break;
			}
		}
		System.out.println("Thank you, goodbye!");


//		while (true) {
//			String userChoice = ui.displayPurchaseMenu();
//			if (userChoice.equals("1"))
//				ui.displayCashRegister();
//		}
	}
}
