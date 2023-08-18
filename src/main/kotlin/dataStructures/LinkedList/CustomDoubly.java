package dataStructures.LinkedList;

public class CustomDoubly {
    private Node head;
    private int size;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.previous = last;
        node.next = null;
    }

    public void insert(int val, int index) {
        Node node = new Node(val);
        Node prev = head;

        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        prev.next = node;
        next.previous = node;

        node.previous = prev;
        node.next = next;
    }

    public void insert(int value, Node existingNode) {
        Node node = new Node(value);
        if (existingNode.next == null) {
            insertLast(value);
            return;
        }
        Node next = existingNode.next;

        existingNode.next = node;
        next.previous = node;

        node.next = next;
        node.previous = existingNode;
    }

    public Node find(int val) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("End of list");

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("Start of list");
    }
    private class Node{
        int value;
        Node next, previous;

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next, Node previous) {
            this.value = val;
            this.next = next;
            this.previous = previous;
        }
    }
}
