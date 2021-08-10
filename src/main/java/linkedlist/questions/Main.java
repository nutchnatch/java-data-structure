package linkedlist.questions;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.create(1);
        ll.insertNode(2);
        ll.insertNode(7);
        ll.insertNode(4);
        ll.insertNode(3);
        ll.traverse();

        Questions questions = new Questions();
//        questions.deleteDups(ll);
//        ll.traverse();

//        Node n = questions.nthToLast(ll, 2);
//        System.out.println(n.value);

//        questions.partition(ll, 4);

        LinkedList llA = new LinkedList();
        llA.insertNode(7);
        llA.insertNode(1);
        llA.insertNode(6);

        LinkedList llB = new LinkedList();
        llB.insertNode(5);
        llB.insertNode(9);
        llB.insertNode(2);

//        LinkedList res = questions.sumList(llA, llB);
//        System.out.println("Result sum");
//        res.traverse();

        questions.addSameNode(llA, llB, 7);
        questions.addSameNode(llA, llB, 2);
        questions.addSameNode(llA, llB, 2);
        Node inter = questions.findIntersection(llA, llB);
        System.out.println("Intersection node: " + inter.value);
        java.util.LinkedList lll = new java.util.LinkedList();

    }
}
