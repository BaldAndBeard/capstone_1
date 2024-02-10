package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {

    // Display Main Menu and Call relevant methods
    public static void run() {
        Scanner userInput = new Scanner(System.in);
        String menuChoice = "";

        // Create instance of LoadInventory and run it's main method to create Products
          LoadInventory productsList = LoadInventory.getInstance();

        // Set loop to continue as long as they do not exit
        while (!menuChoice.equals("3")) {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            System.out.println("Please make a selection using the number keys");
            menuChoice = userInput.nextLine();

            // Print out list of available items for purchase including price and quantity
            if (menuChoice.equals("1")) {

                System.out.println("*******************************************");
                System.out.println(String.format( "%s %18s %7s %10s ","Slot", "Product Name","Price", "Quantity" ));
                for (int i = 0; i < productsList.getAllProducts().size(); i++) {
                    String slotLocation = productsList.getAllProducts().get(i).getSlotLocation();
                    int quantity  = productsList.getAllProducts().get(i).getInitialQuantity();
                    String name = productsList.getAllProducts().get(i).getProductName();
                    int price = productsList.getAllProducts().get(i).getPennyPrice();
                    System.out.println(String.format( "%s %20s %6.2f$ %4d ",slotLocation, name,Double.valueOf(price / 100.00), quantity ));
                }
                System.out.println("*******************************************");

                // Run Transaction Class methods
            } else if (menuChoice.equals("2")) {

                Transactions.transactionMenu(userInput, productsList);

                // Exit and Close Program
            } else if (menuChoice.equals("3")) {

                System.exit(1);

                // Hidden Menu Option that shows total balance of Vending Machine
            } else if (menuChoice.equals("4")) {

                createSalesReport(productsList);

                // Warn user and repeat loop
            } else {
                System.out.println("That was not a valid choice. Please try again.");
            }
        }

    }

    // ChatGPT taught Jay how to use DateTimeFormatter
    public static void createSalesReport(LoadInventory productsList) {

        String salesReportName = "Sales_Report_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".log";
        File salesReportFile = new File(salesReportName);
        try (PrintWriter salesReport = new PrintWriter(new FileOutputStream(salesReportFile))) {

            for (int i = 0; i < productsList.getAllProducts().size(); i++) {
                salesReport.println(productsList.getAllProducts().get(i).getProductName() + "," + (5 - productsList.getAllProducts().get(i).getInitialQuantity()));
            }

            salesReport.println(String.format("%nTotal Balance: %.2f", ((double) Transactions.getTotalBalance() / 100)));
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }
    }
}
