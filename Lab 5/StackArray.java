
package stackarray_mids;

public class StackArray_mids {

    private int[] stackArray;
    private int top;
    private int size;

    // Constructor to initialize the stack
    StackArray_mids(int size) {
        this.size = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    // Push method to add an element to the top of the stack
    public void push(int size) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + size);
            return;
        }
        stackArray[++top] = size;
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Return a special value to indicate an error
        }
        return stackArray[top--];
    }

    // Peek method to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1; // Return a special value to indicate an error
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == size - 1;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        StackArray_mids stack = new StackArray_mids(5); // Creating a stack of size 5

        // Push elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Attempt to push when the stack is full
        stack.push(60); // Should display an error message

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Display the top element again
        System.out.println("Top element after pop operations: " + stack.peek());

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

