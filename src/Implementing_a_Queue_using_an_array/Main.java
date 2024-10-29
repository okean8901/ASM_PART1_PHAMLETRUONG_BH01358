package Implementing_a_Queue_using_an_array;

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Element removed: " + queue.dequeue()); // Output: 10
        System.out.println("Queue size: " + queue.size()); // Output: 2
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false
    }
}
