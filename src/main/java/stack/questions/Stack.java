package stack.questions;
import java.util.EmptyStackException;

public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        System.out.println(stack.isFull());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
    }

    private int capacity;
    public StackNode top;
    public StackNode bottom;
    public int size;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(StackNode above, StackNode bellow) {
        if(bellow != null) {
            bellow.above = above;
        }
        if(above != null) {
            above.bellow = bellow;
        }
    }

    public boolean push(int value) {
        if(size >= capacity) {
            return false;
        }
        size ++;
        StackNode stackNode = new StackNode(value);
        if(size == 1) {
            bottom = stackNode;
        }
        join(stackNode, top);
        top = stackNode;
        return true;
    }

    public int pop() {
        if(size == 0) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        int result = top.value;
        top = top.bellow;
        size --;
        return result;
    }
}
