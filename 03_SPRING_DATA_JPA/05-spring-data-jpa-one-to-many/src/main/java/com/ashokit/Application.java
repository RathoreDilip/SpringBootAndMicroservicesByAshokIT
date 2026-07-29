package com.ashokit;

import com.ashokit.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        EmployeeService service = applicationContext.getBean(EmployeeService.class);

//        service.saveEmployeeWithAddress();

        service.fetchEmployeeById();    // fetchType - Lazy (default) - Lazy means child records will be retrieved on demand basis.


    }

}
