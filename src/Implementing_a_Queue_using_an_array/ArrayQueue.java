package Implementing_a_Queue_using_an_array;

class ArrayQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;
    public ArrayQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }
    public void enqueue(int value) {
        if (currentSize == maxSize) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return value;
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public int size() {
        return currentSize;
    }
}
