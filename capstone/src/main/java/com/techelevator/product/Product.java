package com.techelevator.product;

public abstract class Product {

    String slotLocation;
    String productName;
    int pennyPrice;

    String animalSound;
     int initialQuantity;

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int quantity ) {
        this.initialQuantity = quantity;
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPennyPrice() {
        return pennyPrice;
    }

    public void setPennyPrice(int pennyPrice) {
        this.pennyPrice = pennyPrice;
    }

    public Product(String slotLocation, String productName, int pennyPrice, int initialQuantity) {}




}
