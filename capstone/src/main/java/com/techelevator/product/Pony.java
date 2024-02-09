package com.techelevator.product;

public class Pony extends Product{

    public Pony (String slotLocation, String productName, int pennyPrice, int initialQuantity) {

        super(slotLocation, productName, pennyPrice,initialQuantity);

        this.slotLocation = slotLocation;
        this.productName = productName;
        this.pennyPrice = pennyPrice;
        this.initialQuantity = initialQuantity;
        String animalSound = "Neigh, Neigh, Yay!";


    }
    @Override
    public String toString(){
        return slotLocation + " "+productName +" "+ String.format( "%.2f", Double.valueOf(pennyPrice/100.00)) ;
    }

}
