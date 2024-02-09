package com.techelevator.product;

public class Penguin extends Product{

    public Penguin (String slotLocation, String productName, int pennyPrice, int initialQuantity) {

        super(slotLocation, productName, pennyPrice, initialQuantity);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;
        this.initialQuantity = initialQuantity;
        this.animalSound = "Squawk, Squawk, Whee!";
    }
}
