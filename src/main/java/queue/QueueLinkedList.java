package queue;

import linkedlist.SingleLinkedList;
import linkedlist.questions.LinkedList;

import javax.sound.midi.Soundbank;

public class QueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        System.out.println("Queue is empty: " + queue.isEmpty());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println(queue.isEmpty());
        System.out.println("Dequeue element: " + queue.deQueue());
        System.out.println("Dequeue element: " + queue.deQueue());
        System.out.println("Peek element: " + queue.peek());
        queue.delete();
    }

    private SingleLinkedList linkedList;

    public QueueLinkedList() {
        linkedList = new SingleLinkedList();
        System.out.println("Queue successfully created.");
    }

    public boolean isEmpty() {
        if(linkedList.head == null) {
            return true;
        }
        return false;
    }

    public boolean isFull() {

        return false;
    }

    public void enQueue(int value) {
        linkedList.insertNode(value, linkedList.size);
        System.out.println("Successfully inserted element in the queue");
    }

    public int deQueue() {
        int value = -1;
        if(isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            value = linkedList.head.value;
            linkedList.deleteNode(0);
        }
        return value;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return linkedList.head.value;
        }
    }

    public void delete() {
        linkedList.head = null;
        linkedList.tail = null;
        System.out.println("Queue deleted");
    }
}
