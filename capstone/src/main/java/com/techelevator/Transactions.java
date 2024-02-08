package com.techelevator;

import java.util.Scanner;

public class Transactions {

    private static int workingBalance = 0;
    private static int totalBalance = 0;

    // DISPLAY TRANSACTION MENU ABD CALL RELEVANT METHODS
    public static void transactionMenu(Scanner userInput){
        String menuChoice = "";

        while (!menuChoice.equals("3")) {
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");

            System.out.println("Please make a selection using the number keys");
            System.out.println();
            menuChoice = userInput.nextLine();

            if (menuChoice.equals("1")) {
                feedMoney(userInput);
            } else if (menuChoice.equals("2")) {
                // Select Product Methods
            } else if (menuChoice.equals("3")) {
                // Finish Transaction Methods
            } else {
                System.out.println("That was not a valid choice. Please try again.");
                menuChoice = userInput.nextLine();
            }
        }
    }

    // ACCEPT MONEY FROM USER AND UPDATE workingBalance
    public static void feedMoney(Scanner userInput) {
        System.out.println("Please enter the amount of money you wish to use. Whatever you don't spend will be given as change when you return to the main menu.");

        int amountEntered = (int)(Double.parseDouble(userInput.nextLine()) * 100);

        workingBalance += amountEntered;
    }





}
