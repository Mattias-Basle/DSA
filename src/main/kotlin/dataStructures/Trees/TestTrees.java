package dataStructures.Trees;

import java.util.Scanner;

public class TestTrees {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        CustomBinaryTree tree = new CustomBinaryTree();
//        tree.populate(scanner);
//        tree.display();
//        tree.prettyDisplay();

//        BinarySearchTree tree = new BinarySearchTree();
//        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        tree.populate(nums);
//        tree.display();
//
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        tree.populateSorted(nums);
//        tree.preOrderTraversal();
//        tree.inOrderTraversal();
//        tree.postOrderTraversal();

//        AVL tree = new AVL();
//        for (int i = 0; i < 1000; i++) {
//            tree.insert(i);
//        }
//        System.out.println(tree.heigth());

        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(2, 6));
        tree.update(4, 35);
        System.out.println(tree.query(2, 6));
        tree.display();
    }
}
