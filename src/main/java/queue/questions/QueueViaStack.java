package queue.questions;
import java.util.Stack;

public class QueueViaStack {

    public static void main(String[] args) {
        QueueViaStack queueViaStack = new QueueViaStack();
        queueViaStack.enqueue(1);
        queueViaStack.enqueue(2);
        queueViaStack.enqueue(3);
        System.out.println(queueViaStack.dequeue());
        System.out.println(queueViaStack.dequeue());
        System.out.println(queueViaStack.peek());
        System.out.println(queueViaStack.peek());
    }

    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack() {
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void enqueue(int value) {
        stackNewest.push(value);
    }

    private void shiftStack() {
        if(stackOldest.isEmpty()) {
            while(!stackNewest.isEmpty()) {
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
    }

    public int dequeue() {
        shiftStack();
        return stackOldest.pop();
    }

    public int peek() {
        shiftStack();
        return stackOldest.peek();
    }
}
