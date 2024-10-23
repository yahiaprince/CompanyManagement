package com.mycompany.company;
abstract class Person {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String phone;
    private String gender;

    public Person(String name, String phone, String gender) {
        this.id = idCounter++;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    // SRP: Print responsibility moved to a separate class
    public abstract void printPersonInfo();

    // Getters for encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }
}
