package com.techelevator;

import com.techelevator.product.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadInventory {
    private static List duckList = new ArrayList<>();
    private static List penguinList = new ArrayList<>();
    private static List catList = new ArrayList<>();
    private static List ponyList = new ArrayList<>();

    // GETTERS
    public List<Duck> getDuckList(){
        return duckList;
    }
    public List<Cat> getCatList(){
        return catList;
    }
    public List<Pony> getPonyList(){
        return ponyList;
    }
    public List<Penguin> getpenguinList(){
        return penguinList;
    }

    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(duckList);
        allProducts.addAll(penguinList);
        allProducts.addAll(catList);
        allProducts.addAll(ponyList);

        return allProducts;
    }




    // METHODS
    public static void main(/*String[] args*/) {
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
                    duckList.add(new Duck(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Penguin")) {
                    penguinList.add(new Penguin(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Cat")) {
                    catList.add(new Cat(slotLocation, productName, pennyPrice));
                }
                else if(productType.equals("Pony")) {
                    ponyList.add( new Pony(slotLocation, productName, pennyPrice));
                }
            }
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was not found: " + inPutFile.getAbsolutePath());
        }
    }
}
