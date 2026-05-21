package studentManagementSystem;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        System.out.println("===== Student Management System =====");
        System.out.println("1. Text Interface");
        System.out.println("2. GUI Interface");
        System.out.print("Choose option: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            TextInterface textInterface = new TextInterface(manager);
            textInterface.start();

        } else if (choice == 2) {
        	

            GUI gui = new GUI(manager);
            gui.setVisible(true);

        } else {

            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}