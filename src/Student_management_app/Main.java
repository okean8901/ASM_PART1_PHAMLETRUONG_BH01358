package Student_management_app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Score: ");
            double score = scanner.nextDouble();
            sm.addStudent(new Student(id, name, score));
        }

        // Display all students
        sm.displayStudents();

        // Example operations
        sm.sortStudents(); // Sort students by score
        System.out.println("Students sorted by score:");
        sm.displayStudents();

        // Close the scanner
        scanner.close();
    }
}