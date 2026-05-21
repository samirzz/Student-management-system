package studentManagementSystem;


import java.util.ArrayList;

public class Searching {

    // Search by Name
    public static Student searchByName(ArrayList<Student> students,
                                       String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }
}
