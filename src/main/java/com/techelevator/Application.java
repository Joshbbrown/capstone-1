package com.techelevator;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		VendingUI ui = new VendingUI();

		//do amazing stuff here!
		while (true) {
			String userChoice = ui.printMainMenu();
			if (userChoice.equals("1")) {
				System.out.println("chose option one");
			} else if (userChoice.equals("2")) {
				System.out.println("");
				//TODO: needs to print the aux menu and we need to make it loop in their//
			} else if (userChoice.equals("3")){
				break;
			}
		}
		System.out.println("Thank you, goodbye!");
	}
}
