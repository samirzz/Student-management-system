package studentManagementSystem;

import java.util.Scanner;

public class TextInterface {

    private StudentManager manager;
    private Scanner scanner;

    public TextInterface(StudentManager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    // ================= SAFE INPUT METHODS =================

    private int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a decimal number.");
            }
        }
    }

    private String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    // ================= MAIN MENU =================

    public void start() {

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sort by Name");
            System.out.println("7. Sort by Marks");
            System.out.println("8. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    updateStudent();
                    break;

                case 6:
                    Sorting.sortByName(manager.getStudents());
                    System.out.println("Students sorted by name.");
                    break;

                case 7:
                    Sorting.sortByMarks(manager.getStudents());
                    System.out.println("Students sorted by marks.");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        scanner.close();
    }

    // ================= ADD STUDENT =================

    private void addStudent() {

        int id = readInt("Enter ID: ");
        String name = readString("Enter Name: ");
        int age = readInt("Enter Age: ");
        String course = readString("Enter Course: ");
        double marks = readDouble("Enter Marks: ");

        Student student = new Student(id, name, age, course, marks);
        manager.addStudent(student);
    }

    // ================= SEARCH =================

    private void searchStudent() {

        int id = readInt("Enter Student ID: ");

        Student student = manager.searchStudent(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // ================= DELETE =================

    private void deleteStudent() {

        int id = readInt("Enter Student ID to delete: ");

        boolean deleted = manager.deleteStudent(id);

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // ================= UPDATE =================

    private void updateStudent() {

        int id = readInt("Enter Student ID to update: ");
        String name = readString("Enter New Name: ");
        int age = readInt("Enter New Age: ");
        String course = readString("Enter New Course: ");
        double marks = readDouble("Enter New Marks: ");

        boolean updated = manager.updateStudent(id, name, age, course, marks);

        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}