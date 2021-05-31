package linkedlist;

public class CircleDoublyLinkedList {

    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode create(int value) {
        DoublyNode node = new DoublyNode(value);
        head = node;
        tail = node;
        node.next = node;
        node.prev = node;
        size = 1;
        return head;
    }

    public void insert(int value, int index) {
        DoublyNode newNode = new DoublyNode(value);
        if(head == null) {
            create(value);
            return;
        }
        if(index == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if(index >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode tmpNode = head;
            int i = 0;
            while(i < index - 1) {
                tmpNode = tmpNode.next;
                i ++;
            }
            newNode.prev = tmpNode;
            newNode.next = tmpNode.next;
            tmpNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size ++;
    }

    public void traverse() {
        if(head == null) {
            System.out.println("DLL does not exist.");
            return;
        }
        DoublyNode tmpNode = head;
        for(int i = 0; i < size; i ++) {
            System.out.print(tmpNode.value);
            if(i != size - 1) {
                System.out.print("->");
            }
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }

    public void reverseTraverse() {
        if(head != null) {
            DoublyNode tmpNode = tail;
            for(int i = 0; i < size; i ++) {
                System.out.print(tmpNode.value);
                if(i < size - 1) {
                    System.out.print("<-");
                }
                tmpNode = tmpNode.prev;
            }
        } else {
            System.out.println("DLL does not exist!");
        }
        System.out.println();
    }

    public boolean searchNode(int value) {
        if(head != null) {
            DoublyNode tmpNode = head;
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
        if (head == null) {
            System.out.println("Single Linked List does no exist.");
            return;
        } else if(index == 0) {
            if(size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size --;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size --;
            }
        } else if(index >= size) {
            DoublyNode tempNode = tail.prev;
            if(size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size --;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size --;
            }
        } else {
            DoublyNode tempNode = head;
            for(int i = 0; i < index - 1; i ++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public void deleteCDLL() {
        DoublyNode tempNode = head;
        for(int i = 0; i < size; i ++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }

        head = null;
        tail = null;
        System.out.println("DLL has been deleted!");
    }
}
