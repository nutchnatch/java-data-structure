package linkedlist;

public class CDLLMain {

    public static void main(String[] args) {
        CircleDoublyLinkedList circleDoublyLinkedList = new CircleDoublyLinkedList();

        circleDoublyLinkedList.create(1);
        circleDoublyLinkedList.insert(2, 1);
        circleDoublyLinkedList.insert(3, 2);
        circleDoublyLinkedList.insert(5, 3);
        System.out.println(circleDoublyLinkedList.head.next.value);
        circleDoublyLinkedList.traverse();
        circleDoublyLinkedList.reverseTraverse();
        circleDoublyLinkedList.searchNode(5);
        circleDoublyLinkedList.deleteNode(5);
        circleDoublyLinkedList.traverse();
        circleDoublyLinkedList.deleteCDLL();
        circleDoublyLinkedList.traverse();
    }
}
