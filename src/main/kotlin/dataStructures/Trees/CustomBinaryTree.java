package dataStructures.Trees;

import java.util.Scanner;

public class CustomBinaryTree {

    private Node root;

    public CustomBinaryTree() {}

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner scanner) {
        System.out.print("Enter the Root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Adding a left value to " + node.value + " ? ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter your left value: ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            System.out.println();
            populate(scanner, node.left);
        }

        System.out.print("Adding a right value to " + node.value + " ? ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter your right value: ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            System.out.println();
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);

        if (level!= 0) {
            for (int i = 0; i < level -1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|--->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level +1);
    }
}
