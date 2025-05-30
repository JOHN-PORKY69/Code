/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skibid;

/**
 *
 * @author REX_F
 */
public class LinkedList {

    private int count = 0;
    private MenuNode head;

    public LinkedList() {
        head = null;
    }

    public void InsertFirst(String input) {
        MenuNode newNode = new MenuNode();
        newNode.data = input;
        newNode.next = head;
        head = newNode;
        count++;
    }

    public void insertEnd(String input) {
        if (isEmpty()) {
            InsertFirst(input);
            return;
        }

        MenuNode newNode = new MenuNode();
        newNode.data = input;
        newNode.next = null;

        MenuNode n;
        for (n = head; n.next != null; n = n.next);
        n.next = newNode;
        count++;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            head = head.next;
            count--;
        }
    }
    
    public boolean contains(String item) {
    MenuNode current = head;
    while (current != null) {
        if (current.data.equalsIgnoreCase(item)) {
            return true;
        }
        current = current.next;
    }
    return false;
}

    public boolean search(String keyword) {
        MenuNode current = head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(keyword)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }

        System.out.println("========= MENU ITEMS =========");
        int index = 1;
        for (MenuNode n = head; n != null; n = n.next) {
            System.out.println(index++ + ". " + n.data);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void listCount() {
        System.out.println("The menu has " + count + " items.");
    }

    public void clear() {
        head = null;
        count = 0;
        System.out.println("Menu list cleared.");
    }
}
