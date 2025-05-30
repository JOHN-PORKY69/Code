/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skibid;

/**
 *
 * @author REX_F
 */
public class Stack {

    private String[] stackArr;
    private int stackSize;
    private int top;

    public Stack(int size) {
        stackSize = size;
        stackArr = new String[stackSize];
        top = -1;
    }

    public void push(String newItem) {
        if (isFull()) {
            System.out.println("Modification stack is full!");
        } else {
            stackArr[++top] = newItem;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Modification stack is empty!");
            return null;
        }
        return stackArr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackSize - 1;
    }

    public String stackTop() {
        if (isEmpty()) {
            return null;
        }
        return stackArr[top];
    }

    public int stackCount() {
        return top + 1;
    }

    public void displayStack() {
        System.out.println("========= RECENT MODIFICATIONS =========");
        if (isEmpty()) {
            System.out.println("No modifications available.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println("- " + stackArr[i]);
            }
        }
    }
}
