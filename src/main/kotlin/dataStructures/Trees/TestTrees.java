package dataStructures.Trees;

import java.util.Scanner;

public class TestTrees {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        CustomBinaryTree tree = new CustomBinaryTree();
//        tree.populate(scanner);
//        tree.display();
//        tree.prettyDisplay();

        BinarySearchTree tree = new BinarySearchTree();
//        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        tree.populate(nums);
//        tree.display();

        int[] nums = {1, 2, 3, 4, 5};
        tree.populateSorted(nums);
        tree.display();
    }
}
