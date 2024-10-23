package com.mycompany.company;
public class Client extends Person{
    
    private String email;

    public Client(String name, String phone, String gender, String email) {
        super(name, phone, gender);
        this.email = email;
    }

    @Override
    public void printPersonInfo() {
        System.out.println("Client:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + email);
    }
}
