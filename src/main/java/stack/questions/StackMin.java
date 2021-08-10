package linkedlist.questions;

import stack.Node;

public class StackMin {

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.pop();
        stackMin.push(3);
        System.out.println("Min value:" + stackMin.min());
        stackMin.push(2);
        System.out.println("Min value:" + stackMin.min());
        stackMin.push(5);
        System.out.println("Min value:" + stackMin.min());
        stackMin.push(0);
        System.out.println("Min value:" + stackMin.min());
        stackMin.pop();
        System.out.println("Min value:" + stackMin.min());
        stackMin.pop();
        System.out.println("Min value:" + stackMin.min());
        stackMin.pop();
        System.out.println("Min value:" + stackMin.min());
        stackMin.pop();
        System.out.println("Min value:" + stackMin.min());

    }

    Node top;
    Node min;

    public StackMin() {
        top = null;
        min = null;
    }

    public int min() {
        if(min == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return min.value;
    }

    public void push(int value) {
        if (min == null) {
            min = new Node(value, min);
        } else if (min.value < value) {
            min = new Node(min.value, min);
        } else {
            min = new stack.Node(value, min);
        }
        top = new Node(value, top);
    }

    public int pop() {
        if(top == null) {
            System.out.println("Stack is empty");
            return -1;
        }  else {
            min = min.next;
            int result = top.value;
            top = top.next;
            return result;
        }
    }
}
