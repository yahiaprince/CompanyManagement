package com.mycompany.company;
public class Employee extends Person{
    
    private String workingHours;
    private String workDays;

    public Employee(String name, String phone, String gender, String workingHours, String workDays) {
        super(name, phone, gender);
        this.workingHours = workingHours;
        this.workDays = workDays;
    }

    @Override
    public void printPersonInfo() {
        System.out.println("Employee:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Gender: " + getGender());
        System.out.println("Working Hours: " + workingHours);
        System.out.println("Work Days: " + workDays);
    }
}
