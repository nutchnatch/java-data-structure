package linkedlist;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node create(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return newNode;
    }

    public void insertNode(int value, int index) {
        Node newNode = new Node(value);
        if(head == null) {
            create(value);
            return;
        } else if(index == 0) {
            newNode.next = head;
            head = newNode;
        } else if(index >= size) {
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tmpNode = head;
            int i = 0;
            while(i < index - 1) {
                tmpNode = tmpNode.next;
                i ++;
            }
            Node nextNode = tmpNode.next;
            tmpNode.next = newNode;
            newNode.next = nextNode;
        }
        size ++;
    }

    public void traverse() {
        if(head == null) {
            System.out.println("SLL does not exist.");
            return;
        }
        Node tmpNode = head;
        for(int i = 0; i < size; i ++) {
            System.out.print(tmpNode.value);
            if(i < size - 1) {
                System.out.print("->");
            }
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }

    public boolean searchNode(int value) {
        if(head != null) {
            Node tmpNode = head;
            for(int i = 0; i < size; i ++) {
                if(tmpNode.value == value) {
                    System.out.println("Found node at location - " + i);
                    return true;
                }
                tmpNode = tmpNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    public void deleteNode(int index) {
        if(head == null) {
            System.out.println("Single Linked List does no exist.");
            return;
        } else if(index == 0) { // delete in the beggining
            head = head.next;
            size --;
            if(size == 0) { // one element in ssl
                tail = null;
            }
        } else if(index >= size) { // delete in the end
            Node tmpNode = head;
            for(int i = 0; i < size - 1; i ++) {
                tmpNode = tmpNode.next;
                if(tmpNode == head) { // one element in ssl
                    tail = head = null;
                    size --;
                    return;
                } else {
                    tmpNode.next = null;
                    tail = tmpNode;
                    size --;
                }
            }
        } else {
            Node tmpNode = head;
            for(int i = 0; i < index - 1; i ++) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = tmpNode.next.next;
            size --;
        }
    }

    public void deleteSSL() {
        head = null; // all references will be deleted
        tail = null;
        System.out.println("SLL deleted successfully.");
    }
}
