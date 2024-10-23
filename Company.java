package com.mycompany.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Company {
    private static List<Person> persons = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void addPerson() {
        System.out.println("Enter person type (1 for Employee, 2 for Client): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        if (type == 1) {
            System.out.print("Enter working hours: ");
            String workingHours = scanner.nextLine();

            System.out.print("Enter workdays: ");
            String workDays = scanner.nextLine();

            Employee employee = new Employee(name, phone, gender, workingHours, workDays);
            persons.add(employee);
        } else {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            Client client = new Client(name, phone, gender, email);
            persons.add(client);
        }
    }

    public static void addProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(productName, price);
        products.add(product);
    }

    public static void addOrder() {
        System.out.print("Enter sale date: ");
        String saleDate = scanner.nextLine();

        System.out.print("Enter client name for the order: ");
        String clientName = scanner.nextLine();

        Client client = null;
        for (Person person : persons) {
            if (person instanceof Client && person.getName().equals(clientName)) {
                client = (Client) person;
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Is the order paid (true/false)? ");
        boolean isPaid = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        Order order = new Order(saleDate, client, isPaid);

        while (true) {
            System.out.print("Enter product name to add to order (or type 'done' to finish): ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("done")) {
                break;
            }

            Product product = null;
            for (Product p : products) {
                if (p.getProductName().equals(productName)) {
                    product = p;
                    break;
                }
            }

            if (product == null) {
                System.out.println("Product not found.");
            } else {
                order.addProduct(product);
            }
        }

        orders.add(order);
    }

    public static void printPersonById() {
        System.out.print("Enter person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Person person : persons) {
            if (person.getId() == id) {
                person.printPersonInfo();
                return;
            }
        }
        System.out.println("Person not found.");
    }

    public static void printProductById() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Product product : products) {
            if (product.getProductName().equals(id)) {
                product.printProductDetails();
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void printOrderById() {
        System.out.print("Enter order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Order order : orders) {
            if (order.id == id) {
                order.printOrderDetails();
                return;
            }
        }
        System.out.println("Order not found.");
    }

    public static void removePersonById() {
        System.out.print("Enter person ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        persons.removeIf(person -> person.getId() == id);
        System.out.println("Person removed if existed.");
    }

    public static void removeProductById() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        products.removeIf(product -> product.getProductName().equals(id));
        System.out.println("Product removed if existed.");
    }

    public static void removeOrderById() {
        System.out.print("Enter order ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        orders.removeIf(order -> order.id == id);
        System.out.println("Order removed if existed.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Person");
            System.out.println("2. Add Product");
            System.out.println("3. Add Order");
            System.out.println("4. Print Person by ID");
            System.out.println("5. Print Product by ID");
            System.out.println("6. Print Order by ID");
            System.out.println("7. Remove Person by ID");
            System.out.println("8. Remove Product by ID");
            System.out.println("9. Remove Order by ID");
            System.out.println("10. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    addOrder();
                    break;
                case 4:
                    printPersonById();
                    break;
                case 5:
                    printProductById();
                    break;
                case 6:
                    printOrderById();
                    break;
                case 7:
                    removePersonById();
                    break;
                case 8:
                    removeProductById();
                    break;
                case 9:
                    removeOrderById();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}