package studentManagementSystem;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private StudentManager manager;

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField courseField;
    private JTextField marksField;

    private JTextArea displayArea;

    public GUI(StudentManager manager) {

        this.setManager(manager);

        setTitle("Student Management System");
        setSize(900, 600); // Good fit for 14-inch screens
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== Top Panel =====
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        inputPanel.add(new JLabel("Marks:"));
        marksField = new JTextField();
        inputPanel.add(marksField);

        // ===== Button Panel =====
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 10, 10));

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton searchButton = new JButton("Search Student");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton sortNameButton = new JButton("Sort Name");
        JButton sortMarksButton = new JButton("Sort Marks");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sortNameButton);
        buttonPanel.add(sortMarksButton);
        buttonPanel.add(clearButton);

        // ===== Display Area =====
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Student Records")
        );

        // ===== Main Layout =====
        JPanel northPanel = new JPanel(new BorderLayout(10, 10));
        northPanel.add(inputPanel, BorderLayout.NORTH);
        northPanel.add(buttonPanel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Button Actions =====

        // Add Student
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();
                double marks = Double.parseDouble(marksField.getText());

                Student student = new Student(
                        id, name, age, course, marks
                );

                manager.addStudent(student);

                JOptionPane.showMessageDialog(
                        this,
                        "Student added successfully!"
                );

                clearFields();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid data."
                );
            }
        });

        // View Students
        viewButton.addActionListener(e -> {

            displayArea.setText("");

            if (manager.getStudents().isEmpty()) {
                displayArea.setText("No students found.");
                return;
            }

            for (Student student : manager.getStudents()) {
                displayArea.append(student + "\n");
            }
        });

        // Search Student
        searchButton.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText());

                Student student = manager.searchStudent(id);

                if (student != null) {
                    displayArea.setText(student.toString());
                } else {
                    displayArea.setText("Student not found.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid ID."
                );
            }
        });

        // Update Student
        updateButton.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();
                double marks = Double.parseDouble(marksField.getText());

                boolean updated = manager.updateStudent(
                        id, name, age, course, marks
                );

                if (updated) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Student updated successfully!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Student not found."
                    );
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid data."
                );
            }
        });

        // Delete Student
        deleteButton.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText());

                boolean deleted = manager.deleteStudent(id);

                if (deleted) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Student deleted successfully!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Student not found."
                    );
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid ID."
                );
            }
        });

        // Sort by Name
        sortNameButton.addActionListener(e -> {
            Sorting.sortByName(manager.getStudents());
            displayArea.setText("Sorted by name. Click View Students.");
        });

        // Sort by Marks
        sortMarksButton.addActionListener(e -> {
            Sorting.sortByMarks(manager.getStudents());
            displayArea.setText("Sorted by marks. Click View Students.");
        });

        // Clear Fields
        clearButton.addActionListener(e -> clearFields());
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
        marksField.setText("");
    }

	public StudentManager getManager() {
		return manager;
	}

	public void setManager(StudentManager manager) {
		this.manager = manager;
	}
}

