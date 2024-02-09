package com.techelevator.product;

public class Penguin extends Product{

    public Penguin (String slotLocation, String productName, int pennyPrice, int initialQuantity) {

        super(slotLocation, productName, pennyPrice, initialQuantity);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;
        this.initialQuantity = initialQuantity;
        String animalSound = "Squawk, Squawk, Whee!";


    }

    @Override
    public String toString(){
        return slotLocation + " "+productName +" "+String.format( "%.2f", Double.valueOf((double) pennyPrice/100.00));
    }

}
