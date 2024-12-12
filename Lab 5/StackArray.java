
package stackarray_mids;

public class StackArray_mids {

    private int[] stackArray;
    private int top;
    private int size;

    StackArray_mids(int size) {
        this.size = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int size) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + size);
            return;
        }
        stackArray[++top] = size;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {
        StackArray_mids stack = new StackArray_mids(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.push(60); 

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after pop operations: " + stack.peek());

        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Popped element: " + stack.pop();

        System.out.println("Is the stack empty now? " + stack.isEmpty());
    }
}

