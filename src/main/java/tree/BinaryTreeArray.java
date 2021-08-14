package tree;

public class BinaryTreeArray {

    public static void main(String[] args) {
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(9);
        binaryTreeArray.insert("N1");
        binaryTreeArray.insert("N2");
        binaryTreeArray.insert("N3");
        binaryTreeArray.insert("N4");
        binaryTreeArray.insert("N5");
        binaryTreeArray.insert("N6");
        binaryTreeArray.insert("N7");
        binaryTreeArray.insert("N8");
        binaryTreeArray.insert("N9");
        binaryTreeArray.preOrder(1);
        System.out.println();
        binaryTreeArray.inOrder(1);
        System.out.println();
        binaryTreeArray.postOrder(1);
        System.out.println();
        binaryTreeArray.levelOrder();
        System.out.println();
        binaryTreeArray.search("N5");
        binaryTreeArray.delete("N5");
        binaryTreeArray.levelOrder();
        System.out.println();
        binaryTreeArray.search("N5");
        System.out.println();
        binaryTreeArray.deleteTree();
    }

    String[] arr;
    int lastUsedIndex;

    public BinaryTreeArray(int size) {
        arr = new String[size + 1];
        lastUsedIndex = 0;
        System.out.println("Blank tre of size " + size + " has been created");
    }

    boolean isFull() {
        if(arr.length -1 == lastUsedIndex) {
            return true;
        }
        return false;
    }

    public void insert(String value) {
        if(!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex ++;
            System.out.println("Node has bees inserted with value: " + value);
        } else {
            System.out.println("Binary tree is full");
        }
    }

    // pre order traversal
    public void preOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    public void inOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 +1);
    }

    public void postOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        postOrder(index * 2);
        postOrder(index *2 + 1);
        System.out.print(arr[index] + " ");
    }

    public void levelOrder() {
        for(int i = 1; i <= lastUsedIndex; i ++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int search(String value) {
        for(int i = 1; i <= lastUsedIndex; i ++) {
            if(arr[i].equals(value)) {
                System.out.println("Value " + value + " found in location: " + i);
                return i;
            }
        }
        System.out.print("Element not found in the tree.");
        return -1;
    }

    public void delete(String value) {
        int foundIndex = search(value);
        if(foundIndex == -1) {
            return;
        } else {
            arr[foundIndex] =  arr[lastUsedIndex];
            lastUsedIndex --;
            System.out.println("Node successfully deleted");
        }
    }

    public void deleteTree() {
        try {
            arr = null;
            System.out.println("Tree has been successfully deleted");
        } catch (Exception e) {
            System.out.println("Exception on deleting the tree, " + e);
        }
    }
}
