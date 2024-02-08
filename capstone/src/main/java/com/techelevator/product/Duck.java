package com.techelevator.product;

public class Duck extends Product{

    public Duck (String slotLocation, String productName, int pennyPrice) {

        super(slotLocation, productName, pennyPrice);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;


        String animalSound = "Quack, Quack, Splash!";
        int remainingQuantity = 5;

    }

    @Override
    public String toString(){
        return slotLocation + " "+productName +" "+ pennyPrice ;
    }
}
