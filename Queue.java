/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skibid;

import java.util.*;

public class Queue {

    private String[] myArray;
    private int front, rear, count, maxSize;

    public Queue(int size) {
        myArray = new String[size];
        front = -1;
        rear = -1;
        count = 0;
        maxSize = size;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int queueCount() {
        return count;
    }

    public void enqueue(String add) {
        if (!isFull()) {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1 == maxSize) ? 0 : rear + 1;
            }
            myArray[rear] = add;
            count++;
        } else {
            System.out.println("Order queue is full.");
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            System.out.println("Serving order: " + myArray[front]);
            myArray[front] = null;
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1 == maxSize) ? 0 : front + 1;
            }
            count--;
        } else {
            System.out.println("No orders to serve.");
        }
    }

    public String peekFront() {
        if (!isEmpty()) {
            return myArray[front];
        } else {
            return null;
        }
    }

    public String peekRear() {
        if (!isEmpty()) {
            return myArray[rear];
        } else {
            return null;
        }
    }

    public void display() {
        System.out.println("========= PENDING ORDERS =========");
        if (isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            int i = front;
            for (int j = 0; j < count; j++) {
                System.out.println((j + 1) + ". " + myArray[i]);
                i = (i + 1 == maxSize) ? 0 : i + 1;
            }
        }
    }

    public boolean modify(String targetOrder, LinkedList menu, Stack modifications) {
        if (isEmpty()) {
            System.out.println("No orders to modify.");
            return false;
        }

        boolean found = false;
        int index = front;

        for (int i = 0; i < count; i++) {
            if (myArray[index].startsWith(targetOrder + " -")) {
                System.out.print("Enter new item from the menu: ");
                Scanner sc = new Scanner(System.in);
                String newItem = sc.nextLine();

                if (!menu.search(newItem)) {
                    System.out.println("Item not found in the menu.");
                    return false;
                }

                String oldOrder = myArray[index];
                String newOrder = targetOrder + " - " + newItem;

                myArray[index] = newOrder;

                modifications.push("Modified: " + oldOrder + " -> " + newOrder);

                System.out.println("Order modified successfully.");
                found = true;
                break;
            }

            index++;
            if (index == maxSize) {
                index = 0;
            }
        }

        if (!found) {
            System.out.println("Order not found.");
        }

        return found;
    }
}
