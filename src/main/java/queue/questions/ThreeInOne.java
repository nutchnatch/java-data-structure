package queue.questions;

public class ThreeInOne {

    public static void main(String[] args) {
        ThreeInOne threeInOne = new ThreeInOne(3);
        boolean resultFull = threeInOne.isFull(1);
        threeInOne.push(0,1);
        threeInOne.push(0,2);
        threeInOne.push(1,4);
        threeInOne.push(1,5);
        threeInOne.push(2,8);
        System.out.println("Peek0: " + threeInOne.peek(0));
        System.out.println("Peek1: " + threeInOne.peek(1));
        System.out.println("Peek2: " + threeInOne.peek(2));
        System.out.println("Pop0: " + threeInOne.pop(0));
        System.out.println("Peek0: " + threeInOne.peek(0));
        System.out.println("Pop1: " + threeInOne.pop(1));
        System.out.println("Peek1: " + threeInOne.peek(1));
        System.out.println("Stack is full? " + resultFull);
        boolean resultEmpty = threeInOne.isFull(1);
        System.out.println("Stack is empty? " + resultEmpty);
    }

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * this.numberOfStacks];
        this.sizes = new int[this.numberOfStacks];
    }

    public boolean isFull(int stackNumber) {
        if(this.sizes[stackNumber] == this.stackCapacity) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(int stackNumber) {
        if(this.sizes[stackNumber] == 0) {
            return true;
        }
        return false;
    }

    /**
     * ex: 2 elem in stack1
     *  - stackNumber = 3
     *  - first stack, stackNumber = 0
     *  - offset = 0 * 3 = 0
     *  - size = 2
     *  - return 0 + 2 - 1 = 1 -> indexOfTop
     * @param stackNumber
     * @return
     */
    public int indexOfTop(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = sizes[stackNumber];
        return offset + size - 1;
    }

    public void push(int stackNumber, int value) {
        if(isFull(stackNumber)) {
            System.out.println("Stack is full");
        } else {
            sizes[stackNumber] ++;
            values[indexOfTop(stackNumber)] = value;
        }
    }

    public int pop(int stackNumber) {
        if(isEmpty(stackNumber)) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNumber);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNumber] --;
            return value;
        }
    }

    public int peek(int stackNumber) {
        if(isEmpty(stackNumber)) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNumber);
            return values[topIndex];
        }
    }
}
