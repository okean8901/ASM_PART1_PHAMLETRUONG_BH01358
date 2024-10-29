package Queue_implementation_using_linked_list;

public class LinkedListQueue {
    private Node front;
    private Node rear;
    private int currentSize;
    public LinkedListQueue() {
        front = null;
        rear = null;
        currentSize = 0;
    }
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
        currentSize++;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        currentSize--;
        return value;
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public int size() {
        return currentSize;
    }
}
