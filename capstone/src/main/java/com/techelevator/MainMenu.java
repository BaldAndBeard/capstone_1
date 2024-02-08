package com.techelevator;

import java.util.Scanner;

public class MainMenu extends LoadInventory{


    // Display Main Menu and Call relevant methods
    public static void displayMenu () {
        Scanner userInput = new Scanner(System.in);
        String menuChoice = "";

        // Create instance of LoadInventory and run it's main method to create Products
        LoadInventory li = new LoadInventory();
        li.main();

        // Set loop to continue as long as they do not exit
        while (!menuChoice.equals("3")) {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            System.out.println("Please make a selection using the number keys");
            System.out.println();
            menuChoice = userInput.nextLine();

            // Print out list of available items for purchase including price and quantity
            if (menuChoice.equals("1")) {

                System.out.println("********************");
                System.out.println();
                for (int i = 0; i < li.getAllProducts().size(); i++) {
                    System.out.println(li.getAllProducts().get(i).toString());
                }
                System.out.println();
                System.out.println("********************");

            // Run Transaction Class methods
            } else if (menuChoice.equals("2")) {

                Transactions.transactionMenu(userInput);

            // Exit and Close Program
            } else if (menuChoice.equals("3")) {

                System.exit(1);

            // Warn user and repeat loop
            } else {
                System.out.println("That was not a valid choice. Please try again.");
            }
        }

    }


}
