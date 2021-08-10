package linkedlist.questions;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void create(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int value) {
        if (head == null) {
            create(value);
            return;
        }

        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size ++;
    }

    public void traverse() {
        if(head != null) {
            Node tmpNode = head;
            for(int i = 0; i < size; i ++) {
                System.out.print(tmpNode.value);
                if(i < size - 1) {
                    System.out.print("->");
                }
                tmpNode = tmpNode.next;
            }
        } else {
            System.out.println("LinkedList is empty");
        }
        System.out.println();
    }
}
