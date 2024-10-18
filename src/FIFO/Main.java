package FIFO;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("size of queue: " + queue.size());
        System.out.println("dequeued: " + queue.dequeue());
        System.out.println("dequeued: " + queue.dequeue());
        System.out.println("is queue empty? " + queue.isEmpty());
        System.out.println("dequeued: " + queue.dequeue());
        System.out.println("is queue empty? " + queue.isEmpty());

        try
        {
            queue.dequeue();
        }
        catch (RuntimeException e)
        {
            System.out.println("error: " + e.getMessage());
        }
    }
}
