package Student_management_app_scenario;

import java.util.Random;
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

//        for (int i = 0; i < numberOfStudents; i++) {
//            try {
//                System.out.print("Enter ID: ");
//                int id = scanner.nextInt();
//                scanner.nextLine(); // Consume newline
//                System.out.print("Enter Name: ");
//                String name = scanner.nextLine();
//                System.out.print("Enter Score: ");
//                double score = scanner.nextDouble();
//                sm.addStudent(new Student(id, name, score));  // Có thể ném ngoại lệ
//            } catch (IllegalArgumentException e) {
//                System.out.println("Error: " + e.getMessage()); // Xử lý ngoại lệ đầu vào không hợp lệ
//                i--; // Retry this iteration
//            } catch (DuplicateStudentException e) {
//                System.out.println("Error: " + e.getMessage()); // Xử lý ID trùng lặp
//                i--; // Retry this iteration
//            }
//        }

        for (int i = 0; i < numberOfStudents; i++) {
            int id = i + 1;
            String name = "Nguyen Van An";
            double score = new Random().nextInt(11); // Generates random score between 0 and 10

            sm.addStudent(new Student(id, name + id, score)); // Adds a student
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
                    // Sorting submenu
                    int sortChoice;
                    do {
                        System.out.println("\nSort Menu:");
                        System.out.println("1. Sort by Quick Sort (Default)");
                        System.out.println("2. Sort by Bubble Sort");
                        System.out.println("3. Sort by Merge Sort");
                        System.out.println("4. Return to Main Menu");
                        System.out.print("Enter your sorting choice: ");

                        sortChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (sortChoice) {
                            case 1:
                                // Quick Sort timing and space
                                long quickStartTime = System.currentTimeMillis();
                                Runtime quickRuntime = Runtime.getRuntime();
                                long quickMemoryBefore = quickRuntime.totalMemory() - quickRuntime.freeMemory();

                                sm.sortStudents(); // Quick Sort

                                long quickEndTime = System.currentTimeMillis();
                                long quickMemoryAfter = quickRuntime.totalMemory() - quickRuntime.freeMemory();

                                long quickExecutionTime = quickEndTime - quickStartTime;
                                long quickMemoryUsed = quickMemoryAfter - quickMemoryBefore;

                                System.out.println("Students sorted by Quick Sort (score ascending):");
                                System.out.println("Execution Time: " + quickExecutionTime + " milliseconds");
                                System.out.println("Memory Used: " + quickMemoryUsed + " bytes");
                                System.out.println("Time Complexity: O(n log n) average case");
                                System.out.println("Space Complexity: O(log n) due to recursion");
                                sm.displayStudents();
                                break;
                            case 2:
                                // Bubble Sort timing and space
                                long bubbleStartTime = System.currentTimeMillis();
                                Runtime bubbleRuntime = Runtime.getRuntime();
                                long bubbleMemoryBefore = bubbleRuntime.totalMemory() - bubbleRuntime.freeMemory();

                                sm.bubbleSort();

                                long bubbleEndTime = System.currentTimeMillis();
                                long bubbleMemoryAfter = bubbleRuntime.totalMemory() - bubbleRuntime.freeMemory();

                                long bubbleExecutionTime = bubbleEndTime - bubbleStartTime;
                                long bubbleMemoryUsed = bubbleMemoryAfter - bubbleMemoryBefore;

                                System.out.println("Students sorted by Bubble Sort (score ascending):");
                                System.out.println("Execution Time: " + bubbleExecutionTime + " milliseconds");
                                System.out.println("Memory Used: " + bubbleMemoryUsed + " bytes");
                                System.out.println("Time Complexity: O(n^2)");
                                System.out.println("Space Complexity: O(1)");
                                sm.displayStudents();
                                break;
                            case 3:
                                // Merge Sort timing and space
                                long mergeStartTime = System.currentTimeMillis();
                                Runtime mergeRuntime = Runtime.getRuntime();
                                long mergeMemoryBefore = mergeRuntime.totalMemory() - mergeRuntime.freeMemory();

                                sm.mergeSort();

                                long mergeEndTime = System.currentTimeMillis();
                                long mergeMemoryAfter = mergeRuntime.totalMemory() - mergeRuntime.freeMemory();

                                long mergeExecutionTime = mergeEndTime - mergeStartTime;
                                long mergeMemoryUsed = mergeMemoryAfter - mergeMemoryBefore;

                                System.out.println("Students sorted by Merge Sort (score ascending):");
                                System.out.println("Execution Time: " + mergeExecutionTime + " milliseconds");
                                System.out.println("Memory Used: " + mergeMemoryUsed + " bytes");
                                System.out.println("Time Complexity: O(n log n)");
                                System.out.println("Space Complexity: O(n)");
                                sm.displayStudents();
                                break;
                            case 4:
                                System.out.println("Returning to Main Menu.");
                                break;
                            default:
                                System.out.println("Invalid sorting choice. Please try again.");
                        }
                    } while (sortChoice != 4);
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