package Student_Stack;

public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack(5);

        Student student1 = new Student("1", "Truong", 6);
        Student student2 = new Student("2", "Tien", 8);
        Student student3 = new Student("3", "Hien", 5);

        studentStack.push(student1);
        studentStack.push(student2);
        studentStack.push(student3);

        System.out.println("Top student: " + studentStack.top());
        System.out.println("Student Pop : " + studentStack.pop());
        System.out.println("Top student after pop: " + studentStack.peek());
        System.out.println("Is the stack empty? " + studentStack.isEmpty());
    }
}
