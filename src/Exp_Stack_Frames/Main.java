package Exp_Stack_Frames;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        // Tạo sinh viên
        Student student1 = new Student(1, "Truong", 6);
        Student student2 = new Student(2, "Tien", 8);
        Student student3 = new Student(3, "Hien", 5);

        // Thêm sinh viên vào quản lý
        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        studentManagement.addStudent(student3);

        // Hiển thị sinh viên trước khi cập nhật
        System.out.println("Danh sách sinh viên trước khi cập nhật:");
        studentManagement.displayStudents();

        // Cập nhật thông tin sinh viên
        studentManagement.updateStudent(2, "Tien Nguyen", 9);

        // Hiển thị sinh viên sau khi cập nhật
        System.out.println("\nDanh sách sinh viên sau khi cập nhật:");
        studentManagement.displayStudents();
    }
}
