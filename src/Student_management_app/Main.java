package Student_management_app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng sinh viên
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Thêm sinh viên vào danh sách
        for (int i = 0; i < numberOfStudents; i++) {
            try {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Score: ");
                double score = scanner.nextDouble();
                sm.addStudent(new Student(id, name, score));  // Có thể ném ngoại lệ
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage()); // Xử lý ngoại lệ đầu vào không hợp lệ
            } catch (DuplicateStudentException e) {
                System.out.println("Error: " + e.getMessage()); // Xử lý ID trùng lặp
            }
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all students");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Search student");
            System.out.println("5. Sort students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Hiển thị tất cả sinh viên
                    System.out.println("All students:");
                    sm.displayStudents();
                    break;

                case 2:
                    // Cập nhật thông tin sinh viên
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Score: ");
                    double newScore = scanner.nextDouble();
                    try {
                        sm.updateStudent(updateId, newName, newScore);
                        System.out.println("Student updated successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Xóa sinh viên
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    try {
                        sm.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Tìm kiếm sinh viên
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = sm.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Found student: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    // Sắp xếp và hiển thị sinh viên
                    sm.sortStudents(); // Sắp xếp sinh viên theo điểm số
                    System.out.println("Students sorted by score:");
                    sm.displayStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        // Đóng scanner
        scanner.close();
    }
}