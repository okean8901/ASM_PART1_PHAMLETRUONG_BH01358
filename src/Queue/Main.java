package Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.enqueue(6);
        System.out.println("front element: " + queue.peek());
        queue.dequeue();
        queue.dequeue();
        System.out.println("front element after dequeue: " + queue.peek());
    }
}
