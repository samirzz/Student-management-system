package studentManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentManagerTest {

    @Test
    void testAddStudent() {

        StudentManager manager = new StudentManager();

        Student student =
                new Student(1, "Samir", 22, "IT", 85.5);

        manager.addStudent(student);

        assertEquals(1, manager.getStudents().size());
    }
    
    @Test
    void testSearchStudent() {

        StudentManager manager = new StudentManager();

        Student student =
                new Student(1, "Samir", 22, "IT", 85.5);

        manager.addStudent(student);

        Student found = manager.searchStudent(1);

        assertNotNull(found);
        assertEquals("Samir", found.getName());
    }
    @Test
    void testDeleteStudent() {

        StudentManager manager = new StudentManager();

        Student student =
                new Student(1, "Samir", 22, "IT", 85.5);

        manager.addStudent(student);

        boolean deleted = manager.deleteStudent(1);

        assertTrue(deleted);
        assertEquals(0, manager.getStudents().size());
    }
}
