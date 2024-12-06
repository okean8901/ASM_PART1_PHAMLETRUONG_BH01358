package Student_management_app_scenario;

public class StudentStack {
    private Node top;
    private int size;

    // Inner Node class to represent stack elements
    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public StudentStack() {
        this.top = null;
        this.size = 0;
    }

    // Push a student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return the top student from the stack
    public Student pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Student student = top.data;
        top = top.next;
        size--;
        return student;
    }

    // Return the top student without removing it
    public Student peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the number of students in the stack
    public int size() {
        return size;
    }

    // Clear all students from the stack
    public void clear() {
        top = null;
        size = 0;
    }

    // Search for a student by ID
    public Student searchById(int id) {
        Node current = top;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Update a student in the stack


    // Delete a student from the stack
    public boolean deleteStudent(int id) {
        if (isEmpty()) return false;

        // Special case for top node
        if (top.data.getId() == id) {
            top = top.next;
            size--;
            return true;
        }

        Node current = top;
        Node previous = null;

        while (current != null) {
            if (current.data.getId() == id) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    // Convert stack to array for sorting
    public Student[] toArray() {
        Student[] array = new Student[size];
        Node current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    // Rebuild stack from an array (useful after sorting)
    public void rebuildFromArray(Student[] array) {
        clear();
        for (int i = array.length - 1; i >= 0; i--) {
            push(array[i]);
        }
    }

    // Display all students in the stack
    public void displayStudents() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}