/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackll_mids;

public class StackLL_mids {
    class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
    private Node top;

    public StackLL_mids() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; 
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLL_mids stack = new StackLL_mids();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack after pushing elements:");
        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Stack after popping elements:");
        stack.display();

        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Popped element: " + stack.pop()); 

        System.out.println("Is the stack empty now? " + stack.isEmpty());
    }
}
