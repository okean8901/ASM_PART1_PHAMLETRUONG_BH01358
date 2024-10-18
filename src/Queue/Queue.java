package Queue;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("queue overflow! cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
        System.out.println("enqueued: " + value);
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue underflow! Cannot dequeue.");
            return -1;
        }
        int value = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println("Dequeued: " + value);
        return value;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty! Cannot peek.");
            return -1;
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean isFull() {
        return currentSize == maxSize;
    }
}