package queue;

public class QueueArray {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(3);
        queueArray.enQueue(1);
        queueArray.enQueue(2);
        queueArray.enQueue(3);
        queueArray.enQueue(4);
        System.out.println("Dequeued item: " + queueArray.deQueue());
        System.out.println("Dequeued item: " + queueArray.deQueue());
        System.out.println("Queue is full?");
        System.out.println(queueArray.isFull());
        System.out.println("Queue is empty?");
        System.out.println(queueArray.isEmpty());
        System.out.println("Peek item: " + queueArray.peek());
        System.out.println("Peek item: " + queueArray.peek());
        queueArray.delete();
    }

    private int[] arr;
    int topQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.topQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The queue is successfully created with size of: " + size);
    }

    public boolean isFull() {
        if(topQueue == arr.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(beginningOfQueue == - 1 || beginningOfQueue == arr.length) {
            return true;
        }
        return false;
    }

    public void enQueue(int value) {
        if(isFull()) {
            System.out.println("Tue queue is full.");
        } else if(isEmpty()) {
            this.beginningOfQueue = 0;
            topQueue ++;
            arr[topQueue] = value;
            System.out.println("Successfully inserted " + value  + " in the queue.");
        } else {
            topQueue ++;
            arr[topQueue] = value;
            System.out.println("Successfully inserted " + value  + " in the queue.");
        }
    }

    public int deQueue() {
        int result = -1;
        if(isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            result = arr[beginningOfQueue];
            this.beginningOfQueue ++;
            if(beginningOfQueue > topQueue) {
                this.beginningOfQueue = topQueue = -1;
            }
        }
        return result;
    }

    public int peek() {
        int result = -1;
        if(isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            result = arr[beginningOfQueue];
        }
        return result;
    }

    public void delete() {
        this.arr = null;
        System.out.println("Queue is successfully deleted.");
    }
}
