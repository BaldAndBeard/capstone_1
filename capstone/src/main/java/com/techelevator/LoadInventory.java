package com.techelevator;

import com.techelevator.product.Cat;
import com.techelevator.product.Duck;
import com.techelevator.product.Penguin;
import com.techelevator.product.Pony;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LoadInventory {
    private static List Duck = new ArrayList<>();
    private static List Penguin = new ArrayList<>();
    private static List Cat = new ArrayList<>();
    private static List Pony = new ArrayList<>();
    public static void main(String[] args) {
        // Create a File object using the path
        File inPutFile = new File("vendingmachine.csv");
        // Open the file
        try (Scanner fileInput = new Scanner(inPutFile)) {
            while (fileInput.hasNextLine()) {
                // Read the next line into 'lineOfText'
                String lineOfText = fileInput.nextLine();
                // Split the next line into Array
                String[]  array = lineOfText.split(",");
                // Assign Values form the Array
                String slotLocation = array[0].trim();
                String productName= array[1].trim();
                int pennyPrice = (int) Double.parseDouble(array[2].trim())* 100;
                String productType =array[3].trim();
                // Add items to the list
                if(productType.equals("Duck")) {
                    Duck.add(new Duck(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Penguin")) {
                    Penguin.add(new Penguin(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Cat")) {
                    Cat.add(new Cat(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Pony")) {
                    Pony.add( new Pony(slotLocation, productName, pennyPrice));
                }
            }
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was not found: " + inPutFile.getAbsolutePath());
        }
    }
}
