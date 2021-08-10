package queue;

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        System.out.println("Queue is empty?");
        System.out.println(circularQueue.isEmpty());
        System.out.println("Queue is full?");
        System.out.println(circularQueue.isFull());
        circularQueue.enQueue(10);
        circularQueue.enQueue(20);
        circularQueue.enQueue(30);
        circularQueue.enQueue(40);
        int result = circularQueue.deQueue();
        System.out.println("Dequeued value: " + result);
        circularQueue.enQueue(40);
        System.out.println("Peek element: " + circularQueue.peek());
        circularQueue.delete();
    }

    private int[] arr;
    private int topOfQueue;
    private int beginningOfQueue;
    private int size;

    public CircularQueue(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular queue create successfully with size of: " + this.size);
    }

    public boolean isEmpty() {
        if(this.topOfQueue == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(this.topOfQueue + 1 == this.beginningOfQueue) {
            return true;
        } else if(this.beginningOfQueue == 0 && this.topOfQueue + 1 == this.size) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else if(isEmpty()) {
            this.beginningOfQueue = 0;
            this.topOfQueue ++;
            this.arr[topOfQueue] = value;
            System.out.println("Value " + value + " inserted in the queue");
        } else {
            if(this.topOfQueue + 1 == this.size) {
                this.topOfQueue = 0;
            } else {
                this.topOfQueue ++;
            }
            this.arr[this.topOfQueue] = value;
            System.out.println("Value " + value + " inserted in the queue");
        }
    }

    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int result = arr[this.beginningOfQueue];
            this.arr[this.beginningOfQueue] = 0;
            if(this.beginningOfQueue == this.topOfQueue) {
                this.beginningOfQueue = this.topOfQueue = -1;
            } else if(this.beginningOfQueue + 1 == this.size) {
                this.beginningOfQueue = 0;
            } else {
                this.beginningOfQueue ++;
            }
            return result;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return this.arr[this.beginningOfQueue];
    }

    public void delete() {
        this.arr = null;
        System.out.println("Queue deleted");
    }
}
