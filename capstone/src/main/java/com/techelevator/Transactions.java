package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Transactions  {

    private static int workingBalance = 0;
    private static int totalBalance = 0;

    private static File vendingLog = new File("vending.log");

    public static int getTotalBalance () {
        return totalBalance;
    }

    // DISPLAY TRANSACTION MENU ABD CALL RELEVANT METHODS
    public static void transactionMenu(Scanner userInput, LoadInventory productsList) {
        String menuChoice = "";

        while (!menuChoice.equals("3")) {
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.println("Please make a selection using the number keys");
            menuChoice = userInput.nextLine();

            if (menuChoice.equals("1")) {
                // Feed Money Methods
                 feedMoney(userInput);
            } else if (menuChoice.equals("2")) {
                // Select Product Methods
                selectProduct(userInput, productsList);
            } else if (menuChoice.equals("3")) {
                // Finish Transaction Methods
                finishTransaction();
            } else {
                System.out.println("That was not a valid choice. Please try again.");
               // menuChoice = userInput.nextLine();
            }
        }
    }

    // ACCEPT MONEY FROM USER AND UPDATE workingBalance
    public static void feedMoney(Scanner userInput) {
        System.out.println("Please enter the amount of money you wish to use. Whatever you don't spend will be given as change when you return to the main menu.");

        int amountEntered = (int) (Double.parseDouble(userInput.nextLine()) * 100);

        workingBalance += amountEntered;
        totalBalance += amountEntered;

        System.out.println(String.format("Current Money Provided : %.2f$ %n ",Double.valueOf(workingBalance / 100.00)));

        // Update Vending Log
        try (
                PrintWriter writeFile = new PrintWriter(new FileOutputStream(vendingLog, true));
        ) {

            writeFile.println(LocalDateTime.now() + String.format(" FEED MONEY: $%.2f $%.2f %n", Double.valueOf(amountEntered / 100.00), Double.valueOf(workingBalance / 100.00)));

        } catch (Exception ex) {
            // Alligator Code
        }

    }

    public static void selectProduct(Scanner userInput, LoadInventory productsList) {


        System.out.println(String.format("********************%n"));
        for (int i = 0; i < productsList.getAllProducts().size(); i++) {
            System.out.println(productsList.getAllProducts().get(i));
        }
        System.out.println(String.format("%n********************"));

        System.out.println("Please enter a code to select an item ");

        String selectedItem = userInput.nextLine().trim();

        boolean itemExist = false;

        for (String slotLocation : productsList.getAllSlotLocations()){

            if (slotLocation.equals(selectedItem)){

                itemExist = true;
            }
        }
        if(itemExist)
        {
                dispenseProduct(selectedItem, productsList);
        }
        else {
            System.out.println(String.format("The product code doesn't exist. Please try again.%nReturn to the Purchase menu %n"));
        }
    }

    public static void dispenseProduct(String selectedItem, LoadInventory productsList) {

        for (int i = 0; i < productsList.getAllProducts().size(); i++) {

            String slotLocation = productsList.getAllProducts().get(i).getSlotLocation();
            if (selectedItem.equals(slotLocation) )
            {
                int quantity  = productsList.getAllProducts().get(i).getInitialQuantity();

                if (quantity > 0)
                {
                    quantity--;
                    int price = productsList.getAllProducts().get(i).getPennyPrice();
                    if (workingBalance >= price) {
                        productsList.getAllProducts().get(i).setInitialQuantity(quantity);
                        String name = productsList.getAllProducts().get(i).getProductName();
                        String sound = productsList.getAllProducts().get(i).getAnimalSound();
                        // Decrease workingBalance by the price of the item purchased
                        workingBalance -= price;
                        // Increase totalBalance by the price of the item purchased
                        totalBalance += price;
                        System.out.println(productsList.getAllProducts().get(i).getInitialQuantity());
                        System.out.println(String.format("Selected Item is %s, Price is %.2f, Remaining Balance is %.2f %n%s%n ", name, Double.valueOf(price / 100.00), Double.valueOf(workingBalance / 100.00), sound));


                        // Update Vending Log
                        try (PrintWriter writeFile = new PrintWriter(new FileOutputStream(vendingLog, true))) {

                            writeFile.println(LocalDateTime.now() + String.format(" %s  %s $%.2f $%.2f %n", name, slotLocation, Double.valueOf(price / 100.00), Double.valueOf(workingBalance / 100.00)));

                        } catch (Exception ex) {
                            // Alligator Code
                        }
                    }
                    else
                    {
                    System.out.println(String.format("Insufficient Balance: The Price of the Item selected is %.2f, Remaining Balance is %.2f %n ", Double.valueOf(price / 100.00), Double.valueOf(workingBalance / 100.00)));
                    }
                }
                else
                {
                    System.out.println(String.format("The product is currently Sold Out. Please try again.%nReturn to the Purchase menu %n"));
                }
            }
        }
    }

    public static void finishTransaction() {
        System.out.println(String.format("Thank you for shopping with us. Your change is %.2f %n", Double.valueOf(workingBalance / 100.00)));
        totalBalance -= workingBalance;


        // Update Vending Log
        try (
                PrintWriter writeFile = new PrintWriter(new FileOutputStream(vendingLog, true));
        ) {

            writeFile.println(LocalDateTime.now() + String.format(" Give Change: $%.2f %.2f %n", Double.valueOf(workingBalance / 100.00),  0.00));

        } catch (Exception ex) {
            // Alligator Code
        }

        workingBalance = 0;
    }

    public static void updateLog(LoadInventory productList){

        File vendingLog = new File("vending.log");


        try (
                PrintWriter writeFile = new PrintWriter(new FileOutputStream(vendingLog, true));
        ) {

            writeFile.println(LocalDateTime.now() + "");

        } catch (Exception ex) {
            // Alligator Code
        }
    }

}
