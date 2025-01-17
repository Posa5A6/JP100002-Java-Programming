/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MR.POSA
 */
import java.util.Scanner;

public class StudentUI {
    private final StudentService studentService;
    private final Scanner scanner = new Scanner(System.in);

    public StudentUI(StudentService studentService) {
        this.studentService = studentService;
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> handleAddStudent();
                case 2 -> handleViewStudents();
                case 3 -> handleUpdateStudent();
                case 4 -> handleDeleteStudent();
                case 5 -> handleSortByMarks();
                case 6 -> handleSortByName();
                case 7 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private void handleAddStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        studentService.addStudent(id, name, marks);
    }

    private void handleViewStudents() {
        var students = studentService.viewAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        students.forEach(System.out::println);
    }

    private void handleUpdateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Marks: ");
        int newMarks = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (studentService.updateStudent(id, newName, newMarks)) {
            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void handleDeleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void handleSortByMarks() {
        studentService.sortByMarks();
        System.out.println("Students sorted by marks in descending order.");
        handleViewStudents();
    }

    private void handleSortByName() {
        studentService.sortByName();
        System.out.println("Students sorted by name in alphabetical order.");
        handleViewStudents();
    }
}
