package com.techelevator.product;

public class Penguin extends Product{

    public Penguin (String slotLocation, String productName, int pennyPrice) {

        super(slotLocation, productName, pennyPrice);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;

        String animalSound = "Squawk, Squawk, Whee!";

    }

    @Override
    public String toString(){
        return slotLocation + " "+productName +" "+ pennyPrice ;
    }

}
