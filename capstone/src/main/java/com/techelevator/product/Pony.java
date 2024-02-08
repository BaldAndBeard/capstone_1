package com.techelevator.product;

public class Pony extends Product{

    public Pony (String slotLocation, String productName, int pennyPrice) {

        super(slotLocation, productName, pennyPrice);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;

        String animalSound = "Neigh, Neigh, Yay!";

    }
    @Override
    public String toString(){
        return slotLocation + " "+productName +" "+ pennyPrice ;
    }

}
