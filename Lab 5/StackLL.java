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

    // Constructor to initialize the stack
    public StackLL_mids() {
        this.top = null;
    }

    // Push method to add an element to the top of the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Return a special value to indicate an error
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    // Peek method to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1; // Return a special value to indicate an error
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to display the stack
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

    // Main method to test the functionality
    public static void main(String[] args) {
        StackLL_mids stack = new StackLL_mids();

        // Push elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Display the stack
        System.out.println("Stack after pushing elements:");
        stack.display();

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Display the stack again
        System.out.println("Stack after popping elements:");
        stack.display();

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Pop remaining elements
        stack.pop();
        stack.pop();
        stack.pop();

        // Attempt to pop when the stack is empty
        System.out.println("Popped element: " + stack.pop()); // Should display an error message

        // Check if the stack is empty again
        System.out.println("Is the stack empty now? " + stack.isEmpty());
    }
}
