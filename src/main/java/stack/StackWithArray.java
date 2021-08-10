package stack;

public class Stack {

    private int[] arr;
    int topOfStack;

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int result = stack.pop();
        System.out.println(result);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.deleteStack();
    }

    public Stack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("This stack is created with size of: " + size);
    }

    public boolean isEmpty() {
        if(topOfStack == -1) {
            System.out.println("Stack is empty.");
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(topOfStack == arr.length - 1) {
            System.out.println("Stack is full.");
            return true;
        }
        return false;
    }

    public void push(int val) {
        if(isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[topOfStack+1] = val;
            topOfStack ++;
            System.out.println("The value is successfully inserted.");
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int topStack = arr[topOfStack];
            topOfStack --;
            return topStack;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
           return arr[topOfStack];
        }
    }

    public void deleteStack() {
        arr = null;
        System.out.println("Stack is successfully deleted.");
    }
}
