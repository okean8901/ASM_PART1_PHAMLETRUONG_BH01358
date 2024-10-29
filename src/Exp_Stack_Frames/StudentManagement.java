package Exp_Stack_Frames;

import java.util.Stack;

public class StudentManagement {
    private Stack<Student> students;

    public StudentManagement() {
        this.students = new Stack<>();
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent(int id, String newName, double newScore) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        // Lấy từng sinh viên ra khỏi ngăn xếp
        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                // Tạo sinh viên mới với thông tin đã cập nhật
                tempStack.push(new Student(id, newName, newScore));
                found = true;
            } else {
                tempStack.push(student); // Giữ lại sinh viên khác
            }
        }

        // Khôi phục lại ngăn xếp sinh viên
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Sinh viên với ID " + id + " không được tìm thấy.");
        }
    }

    // Hiển thị tất cả sinh viên
    public void displayStudents() {
        Stack<Student> tempStack = new Stack<>();

        // In thông tin từng sinh viên và đẩy vào tempStack
        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        // Khôi phục lại ngăn xếp sinh viên ban đầu
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Phương thức thêm sinh viên (để thử nghiệm)
    public void addStudent(Student student) {
        students.push(student);
    }
}
