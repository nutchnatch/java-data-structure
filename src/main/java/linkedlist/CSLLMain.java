package linkedlist;

public class CSLLMain {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.createNode(5);
        circleSingleLinkedList.insert(4, 0);
        circleSingleLinkedList.insert(6, 1);
        circleSingleLinkedList.insert(7, 8);
//        System.out.println(circleSingleLinkedList.head.value);
        circleSingleLinkedList.traverse();
        circleSingleLinkedList.searchNode(10);
        circleSingleLinkedList.deleteNode(1);
        circleSingleLinkedList.traverse();
        circleSingleLinkedList.deleteCSLL();
        circleSingleLinkedList.traverse();
    }
}
