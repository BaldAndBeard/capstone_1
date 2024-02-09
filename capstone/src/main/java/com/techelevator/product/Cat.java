package com.techelevator.product;

public class Cat extends Product{

    public Cat (String slotLocation, String productName, int pennyPrice, int initialQuantity) {

        super(slotLocation, productName, pennyPrice,initialQuantity);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;
        this.initialQuantity = initialQuantity;
        this.animalSound = "Meow, Meow, Meow!";
    }
}
