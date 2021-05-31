package linkedlist;

import org.omg.PortableInterceptor.INACTIVE;

public class CircleSingleLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createNode(int nodeValue) {
//        head = new Node();
        Node node = new Node(nodeValue);
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int value, int index) {
        Node node = new Node(value);
        if(head == null) {
            createNode(value);
            return;
        } else if(index == 0) {
            node.next = head; // point to first node
            head = node;
            tail.next = head;
        } else if(index >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tmpNode = head;
            int i = 0;
            while(i < index - 1) {
                tmpNode = tmpNode.next;
                i ++;
            }
            Node nextNode = tmpNode.next;
            tmpNode.next = node;
            node.next = nextNode;
        }
        size ++;
    }

    public void traverse() {
        if(head != null) {
            Node tmpNode = head;
            for(int i = 0; i < size; i ++) {
                System.out.print(tmpNode.value);
                if(i != size - 1) {
                    System.out.print("->");
                }
                tmpNode = tmpNode.next;
            }
        } else {
            System.out.println("CSLL does not exist!");
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
            System.out.println("CSLL does not exist!");
        } else if(index == 0) {
            head = head.next;
            tail.next = head;
            size --;
            if(size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if(index >= size) {
            Node tmpNode = head;
            for(int i = 0; i < size - 1; i ++) {
                tmpNode = tmpNode.next;
            }
            if(tmpNode == head) {
                head.next = null;
                head = null;
                size --;
                return;
            }
            tmpNode.next = head;
            tail = tmpNode;
            size --;
            return;
        } else {
            Node tmpNode = head;
            for(int i = 0; i < index - 1; i ++) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = tmpNode.next.next;
            size --;
        }
    }

    public void deleteCSLL() {
        if(head == null) {
            System.out.println("CSLL does not exist!");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("CSLL successfully deleted!");
        }
    }
}
