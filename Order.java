package com.mycompany.company;
import java.util.ArrayList;
import java.util.List;
public class Order {
    
    private static int idCounter = 1;
    int id;
    private String saleDate;
    private Client client;
    private boolean isPaid;
    private List<Product> products;

    public Order(String saleDate, Client client, boolean isPaid) {
        this.id = idCounter++;
        this.saleDate = saleDate;
        this.client = client;
        this.isPaid = isPaid;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("Sale Date: " + saleDate);
        System.out.println("Client: " + client.getName());
        System.out.println("Payment Status: " + (isPaid ? "Paid" : "Unpaid"));
        System.out.println("Products:");
        for (Product product : products) {
            product.printProductDetails();
        }
    }
}
