package dataStructures.Trees;

public class AVL {
    private Node root;

    public AVL() {}

    public int heigth(Node node) {
        return (node == null) ? -1 : node.height;
    }

    public int heigth() {
        return heigth(root);
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
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (heigth(node.left) - heigth(node.right) > 1) {
            //left heavy ==> right rotation on parent
            if (heigth(node.left.left) - heigth(node.left.right) < 0) {
                // left - right case ==> left rotation on child
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        if (heigth(node.left) - heigth(node.right) < -1) {
            //right heavy ==> left rotation on parent
            if (heigth(node.right.left) - heigth(node.right.right) > 0) {
                // right - left case ==> right rotation on child
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(heigth(p.left), heigth(p.right) + 1) ;
        c.height = Math.max(heigth(c.left), heigth(c.right) + 1) ;
        return p;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(heigth(p.left), heigth(p.right) + 1) ;
        c.height = Math.max(heigth(c.left), heigth(c.right) + 1);
        return c;
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
}
