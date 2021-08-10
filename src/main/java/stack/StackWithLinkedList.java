package stack;

import linkedlist.SingleLinkedList;
import linkedlist.questions.LinkedList;

public class StackWithLinkedList {
    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();
        System.out.println("is empty? ->" + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("is empty? ->" + stack.isEmpty());
        System.out.println("Pop -> " + stack.pop());
        System.out.println("Peek -> " + stack.peek());
        System.out.println("Pop -> " + stack.pop());
        stack.delete();
    }

    public StackWithLinkedList() {

    }
    private SingleLinkedList linkedList = new SingleLinkedList();

    public void push(int value) {
        linkedList.insertNode(value, 0);
        System.out.println("Inserted " + value + " in Stack");
    }

    public boolean isEmpty() {
        if(linkedList.head == null) {
            return true;
        }
        return false;
    }

    public int pop() {
        int result = -1;
        if(isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            result = linkedList.head.value;
            linkedList.deleteNode(0);
        }
        return result;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return linkedList.head.value;
        }
    }

    public void delete() {
        linkedList.head = null;
        linkedList.tail = null;
        System.out.println("Stack is deleted");
    }
}
