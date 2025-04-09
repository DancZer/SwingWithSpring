package employees;

import employees.backend.EmployeeController;
import employees.swing.EmployeeView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication app = new SpringApplication(MainApp.class);

        boolean isSwingOnly = args.length == 1 && args[0].equals("-swing");

        if(isSwingOnly) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if(isSwingOnly) {
            EmployeeController userController = context.getBean(EmployeeController.class);
            SwingUtilities.invokeLater(() -> new EmployeeView(userController));
        }
    }
}
