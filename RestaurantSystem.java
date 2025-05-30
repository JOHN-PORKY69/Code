/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skibid;

import java.util.*;

public class RestaurantSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList menu = new LinkedList();
        LinkedList customers = new LinkedList();
        Queue orderQueue = new Queue(10);
        Stack modifications = new Stack(10);

        initializeMenu(menu);

        while (true) {
            showMainMenu();
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    if (orderQueue.isFull()) {
                        System.out.println("Cannot take more orders. Queue is full.");
                    } else {
                        System.out.print("Enter customer name: ");
                        String name = input.nextLine();
                        customers.insertEnd(name);

                        String order = name + " - ";
                        boolean adding = true;

                        while (adding) {
                            menu.display();
                            System.out.print("Enter item (type 'done' to finish): ");
                            String item = input.nextLine();

                            if (item.equalsIgnoreCase("done")) {
                                adding = false;
                            } else if (!menu.contains(item)) {
                                System.out.println("Item not found in menu.");
                            } else {
                                if (!order.endsWith(" - ")) {
                                    order += ", ";
                                }
                                order += item;
                            }
                        }

                        orderQueue.enqueue(order);
                        System.out.println("Order placed: " + order);
                    }
                }
                case 2 ->
                    orderQueue.dequeue();
                case 3 -> {
                    if (orderQueue.isEmpty()) {
                        System.out.println("No orders to modify or cancel.");
                    } else {
                        orderQueue.display();
                        System.out.print("Enter customer name to modify/cancel order: ");
                        String name = input.nextLine();

                        if (!orderQueue.modify(name, menu, modifications)) {
                            System.out.println("Order not found.");
                        }
                    }
                }
                case 4 ->
                    orderQueue.display();
                case 5 ->
                    modifications.displayStack();
                case 6 -> {
                    System.out.print("Enter customer name to search: ");
                    String name = input.nextLine();
                    if (customers.search(name)) {
                        System.out.println(name + " found in profiles.");
                    } else {
                        System.out.println(name + " not found.");
                    }
                }
                case 7 -> {
                    System.out.println("Thank you for using the Restaurant Order Management System.");
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeMenu(LinkedList menu) {
        menu.insertEnd("Fried Chicken");
        menu.insertEnd("Beef Steak");
        menu.insertEnd("Tuna Sizzling");
        menu.insertEnd("Cake");
        menu.insertEnd("Ice Cream");
        menu.insertEnd("Pie");
        menu.insertEnd("Mountain Dew");
        menu.insertEnd("Coke");
        menu.insertEnd("Sprite");
    }

    private static void showMainMenu() {
        System.out.println("========= RESTAURANT ORDER SYSTEM =========");
        System.out.println("[1] Take New Customer Order");
        System.out.println("[2] Serve Next Order");
        System.out.println("[3] Cancel/Modify Order");
        System.out.println("[4] View All Orders");
        System.out.println("[5] View Recent Modifications");
        System.out.println("[6] Search Customer Profile");
        System.out.println("[7] Exit");
        System.out.print("Choice: ");
    }
}
