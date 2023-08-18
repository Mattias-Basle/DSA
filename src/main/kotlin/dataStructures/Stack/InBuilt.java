package dataStructures.Stack;

import java.util.Stack;

public class InBuilt {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("current top: " + stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("end? " + stack.empty());
        System.out.println(stack.pop());
        System.out.println("end? " + stack.empty());
    }
}
