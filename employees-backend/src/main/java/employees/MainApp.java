package employees;

import employees.backend.EmployeeController;
import employees.swing.EmployeeView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");

        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
        EmployeeController userController = context.getBean(EmployeeController.class);
        SwingUtilities.invokeLater(() -> new EmployeeView(userController));
    }

}
