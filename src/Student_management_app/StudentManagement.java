package Student_management_app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class StudentManagement {
    private Stack<Student> students;

    public StudentManagement() {
        this.students = new Stack<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.push(student);
    }

    // Update existing student's details
    public void updateStudent(int id, String newName, double newScore) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newScore));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("student with ID " + id + " not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack<>();

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Not found
    }



    // Display all students
    public void displayStudents() {
        Stack<Student> tempStack = new Stack<>();

        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Sort students by score
    public void sortStudents() {
        List<Student> studentList = new ArrayList<>(students);
        studentList.sort(Comparator.comparingDouble(Student::getScore));
        students.clear();
        for (Student student : studentList) {
            students.push(student);
        }
    }
}
