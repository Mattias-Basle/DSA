package dataStructures.LinkedList;

public class CustomCircular {
    private Node head, tail;

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        head = node;
    }

    public void delete(int value) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.val == value) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.val == value) {
                node.next = n.next;
                break;
            }
            node = node.next;
        }
        while (node != head);
    }

    public void display() {
        Node temp = head;
        while (temp != tail) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        if (temp != null) {
            System.out.println(temp.val + " -> " + temp.next.val + " (head)");
        }
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
