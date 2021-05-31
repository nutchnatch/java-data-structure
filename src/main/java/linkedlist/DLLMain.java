package linkedlist;

public class DLLMain {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.create(1);
        doublyLinkedList.insert(2, 0);
        doublyLinkedList.insert(3,  1);
        doublyLinkedList.insert(4, 7);
//        System.out.println(doublyLinkedList.head.value);
//        System.out.println(doublyLinkedList.head.next.next.value);
        doublyLinkedList.traverse();
        doublyLinkedList.reverseTraverse();
        doublyLinkedList.searchNode(4);
        doublyLinkedList.deleteNode(4);
        doublyLinkedList.traverse();
        doublyLinkedList.reverseTraverse();
        doublyLinkedList.deleteDLL();
        doublyLinkedList.traverse();
    }
}
