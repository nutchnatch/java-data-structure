package stack.questions;

public class StackNode {
    public StackNode above;
    public StackNode bellow;
    public int value;

    public StackNode(int value) {
        this.value = value;
    }
}
