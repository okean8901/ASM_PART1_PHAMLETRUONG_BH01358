package Student_Stack;

//Lớp StudentStack được triển khai bằng cách sử dụng một mảng (Student[] stack) để lưu trữ các đối tượng Student.

//class StudentStack {
//    private Student[] stack;
//    private int top;
//    private int capacity;
//
//    public StudentStack(int size) {
//        stack = new Student[size];
//        capacity = size;
//        top = -1;
//    }
//
//    public void push(Student student) {
//        if (top == capacity - 1) {
//            System.out.println("Stack full! Cannot add students.");
//            return;
//        }
//        stack[++top] = student;
//    }
//
//    public Student pop() {
//        if (isEmpty()) {
//            System.out.println("Stack is empty! Cannot pop.");
//            return null;
//        }
//        return stack[top--];
//    }
//
//    public Student peek() {
//        if (isEmpty()) {
//            System.out.println("Stack is empty! Cannot peek.");
//            return null;
//        }
//        return stack[top];
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }
//
//    public Student top() {
//        return peek();
//    }
//}


//StudentStack sử dụng danh sách liên kết với lớp Node để lưu trữ các đối tượng Student.
class StudentStack {
    private Node top;

    public StudentStack(int i) {
        top = null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return null;
        }
        return top.student;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Student top() {
        return peek();
    }
}