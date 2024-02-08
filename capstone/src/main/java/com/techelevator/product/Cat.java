package com.techelevator.product;

public class Cat extends Product{

    public Cat (String slotLocation, String productName, int pennyPrice) {

        super(slotLocation, productName, pennyPrice);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;

        String animalSound = "Meow, Meow, Meow!";

    }


}
