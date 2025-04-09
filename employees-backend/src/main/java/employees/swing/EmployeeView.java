package employees.swing;

import employees.backend.EmployeeController;
import employees.backend.EmployeeDto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmployeeView extends JFrame {

    private final EmployeeController employeeController;

    private JTextField usernameField;
    private JTextField emailField;
    private JTextArea displayArea;

    public EmployeeView(EmployeeController userController) {
        this.employeeController = userController;

        setTitle("User Manager");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add User");
        inputPanel.add(addButton);
        JButton loadButton = new JButton("Load Users");
        inputPanel.add(loadButton);

        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> addUser());
        loadButton.addActionListener(e -> loadUsers());

        setVisible(true);
    }

    private void addUser() {
        Long id = 1L;
        String username = usernameField.getText();
        String email = emailField.getText();
        if (!username.isEmpty() && !email.isEmpty()) {
            employeeController.save(new EmployeeDto(id, username, email));
            JOptionPane.showMessageDialog(this, "User added!");
        }
    }

    private void loadUsers() {
        List<EmployeeDto> users = employeeController.findAll();
        displayArea.setText("");
        for (EmployeeDto employee : users) {
            displayArea.append("Username: " + employee.name() + ", Email: " + employee.email() + "\n");
        }
    }
}