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

    // Thêm sinh viên mới
    public void addStudent(Student student) {
        if (searchStudent(student.getId()) != null) {
            throw new DuplicateStudentException("Student ID already exists");
        }
        students.push(student);
    }

    // Cập nhật thông tin sinh viên
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
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Xóa sinh viên theo ID
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

    // Tìm sinh viên theo ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Không tìm thấy
    }

    // Hiển thị tất cả sinh viên
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

    // Sắp xếp sinh viên theo điểm
    public void sortStudents() {
        List<Student> studentList = new ArrayList<>(students);
        studentList.sort(Comparator.comparingDouble(Student::getScore));
        students.clear();
        for (Student student : studentList) {
            students.push(student);
        }
    }
}