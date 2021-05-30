package linkedlist;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.create(5);
//        System.out.println(singleLinkedList.head.value);
        singleLinkedList.insertNode(6, 1);
        singleLinkedList.insertNode(7, 3);
        singleLinkedList.insertNode(8, 4);
//        singleLinkedList.insertNode(9, 5);
        singleLinkedList.insertNode(9, 0);
//        System.out.println(singleLinkedList.head.next.next.value);
        singleLinkedList.traverse();
        singleLinkedList.searchNode(9);
        singleLinkedList.searchNode(2);
        singleLinkedList.deleteNode(3);
        singleLinkedList.traverse();
    }
}
