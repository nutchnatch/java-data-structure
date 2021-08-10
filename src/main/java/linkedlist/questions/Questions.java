package linkedlist.questions;
import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.Set;

public class Questions {

    // Q1 - delete duplicates
    void deleteDups(LinkedList ll) {
        Set<Integer> set = new HashSet<Integer>();
        Node current = ll.head;
        Node prev = null;
        while(current != null) {
            int curValue = current.value;
            if(set.contains(curValue)) {
                prev.next = current.next;
                ll.size --;
            } else {
                set.add(curValue);
                prev = current;
            }
            current = current.next;
        }
    }

    // Q2 - nth to last
    Node nthToLast(LinkedList ll, int n) {
        Node p1 = ll.head;
        Node p2 = ll.head;
        for(int i = 0; i < n; i ++) {
            if(p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // Q3 - partitions
    LinkedList partition(LinkedList ll, int x) {
        Node currentNode = ll.head;
        ll.tail = ll.head;
        while(currentNode != null) {
            Node next = currentNode.next;
            if(currentNode.value < x) {
                currentNode.next = ll.head;
                ll.head = currentNode;
            } else {
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = next;
        }
        ll.tail.next = null;
        return ll;
    }

    // Q4 - adds numbers
    LinkedList sumList(LinkedList llA, LinkedList llB) {
        Node n1 = llA.head;
        Node n2 = llB.head;
        int carry = 0;
        LinkedList resultLL = new LinkedList();
        while(n1 != null || n2 != null) {
            int result = carry;
            if(n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }
            if(n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }
            resultLL.insertNode(result%10);
            carry = result / 10;
        }
        return resultLL;
    }

    //Q5 - Intersection
    Node getKthNode(Node head, int k) { // k is node's index
        Node current = head;
        while(k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    // Intersection
    Node findIntersection(LinkedList l1, LinkedList l2) {
         if(l1.head == null || l2.head == null) {
             return null;
         }

         if(l1.tail != l2.tail) {
             return null;
         }
         Node shorter = new Node();
         Node longer = new Node();
         if(l1.size > l2.size) {
            longer = l1.head;
            shorter = l2.head;
         } else {
             longer = l2.head;
             shorter = l1.head;
         }
         int diff = Math.abs(l1.size - l2.size);
         longer = getKthNode(longer, diff);
         while(longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
         }
         return longer;
    }

    // Add same node
    void addSameNode(LinkedList llA, LinkedList llB, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        llA.tail.next = newNode;
        llA.tail = newNode;
        llB.tail.next = newNode;
        llB.tail = newNode;
    }
}
