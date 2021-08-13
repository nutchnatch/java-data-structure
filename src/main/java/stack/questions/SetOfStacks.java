package stack.questions;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.popAt(0)); //should return 3, since it is the last element on that stack (stack size = 3)
        System.out.println(setOfStacks.popAt(0)); //should return 4, since we are shifting left the bottom of next stack
    }

    List<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if(stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
       Stack last = getLastStack();
       if(last != null && !last.isFull()) {
           last.push(value);
       } else {
           Stack newStack = new Stack(capacity);
           newStack.push(value);
           stacks.add(newStack);
       }
    }

    public int pop() {
        Stack last = getLastStack();
        if(last == null) {
             throw new EmptyStackException();
        }
        int result = last.pop();
        if(last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return result;
    }

    //helper left shift
    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if(removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }
        if(stack.size == 0) {
            stacks.remove(index);
        } else if(stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return  removedItem;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }
}
