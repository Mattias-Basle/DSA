package dataStructures.Trees;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public int heigth(Node node) {
        return (node == null) ? -1 : node.height;
    }

    public void insert(int val) {
        root = insert(this.root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.getValue()) {
            node.left = insert(node.left, val);
        }
        if (val > node.getValue()) {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(heigth(node.left), heigth(node.right)) + 1;
        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(heigth(node.left) - heigth(node.right)) <= 1 &&
                balanced(node.left) && balanced(node.right);
    }


    public Node find(int val) {
        if (this.isEmpty()) {
            return null;
        }
        if (val == root.getValue()) {
            return root;
        }
        if (val < root.getValue()) {
            return find(root.left, val);
        }
        return find(root.right, val);
    }

    private Node find(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (val == node.getValue()) {
            return node;
        }
        if (val < node.getValue()) {
            return find(node.left, val);
        }
        return find(node.right, val);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    private class Node {
        private int value, height;
        private Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
