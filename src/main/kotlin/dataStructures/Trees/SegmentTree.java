package dataStructures.Trees;

public class SegmentTree {

    Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length -1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);

        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int start, int end) {
        return this.query(this.root, start, end);
    }

    private int query(Node node, int start, int end) {
        if (node.start >= start && node.end <= end) {
            return node.data;
        }
        else if (node.start > end || node.end < start) {
            return 0;
        } else {
            return this.query(node.left, start, end) + query(node.right, start, end);
        }
    }

    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.start && index <= node.end) {
            if (index == node.start && index == node.end) {
                node.data = value;
                return node.data;
            } else {
                int left = update(node.left, index, value);
                int right = update(node.right, index, value);

                node.data = left + right;
                return node.data;
            }
        }
        return node.data;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str += "Interval=[" + node.left.start + "-" + node.left.end + "]; data: " + node.left.data + " ->";
        } else {
            str += "No left child / ";
        }

        str += "Interval=[" + node.start + "-" + node.end + "]; data: " + node.data;

        if (node.right != null) {
            str += " <- Interval=[" + node.right.start + "-" + node.right.end + "]; data: " + node.right.data;
        } else {
            str += " / No right child";
        }

        System.out.println(str);

        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    private class Node {
        int data, start, end;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
