package FIFO;

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear != null ) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
        size++;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("dequeue from empty queue");
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }
    public int size() {
        return size;
    }
}
