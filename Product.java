package com.mycompany.company;
public class Product {
    private static int idCounter = 1;
    private int id;
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.id = idCounter++;
        this.productName = productName;
        this.price = price;
    }

    public void printProductDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    public String getProductName() {
        return productName;
    }
}
