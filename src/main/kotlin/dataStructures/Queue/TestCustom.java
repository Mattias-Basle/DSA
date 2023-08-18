package dataStructures.Queue;

public class TestCustom {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(17);
        queue.add(59);
        queue.display();

        queue.remove();
        queue.display();
    }
}
