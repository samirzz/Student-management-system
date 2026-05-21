package studentManagementSystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Sorting {

    // Sort by Name
    public static void sortByName(ArrayList<Student> students) {

        Collections.sort(students, Comparator.comparing(Student::getName));

        System.out.println("Students sorted by name.");
    }

    // Sort by Marks
    public static void sortByMarks(ArrayList<Student> students) {

        Collections.sort(students,
                Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("Students sorted by marks.");
    }
}
