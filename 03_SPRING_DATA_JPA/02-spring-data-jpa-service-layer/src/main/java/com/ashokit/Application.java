package com.ashokit;

import com.ashokit.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeService service = context.getBean(EmployeeService.class);
//		service.saveEmployee();

//		service.getAllEmployee();

		service.getFindAllByIdEmployee();

		service.findByEmpName("Deep");

		service.findByEmpSalary(77000.0);

		service.findByEmpNameAndEmpSalary("Aman",77000.0);

		service.findByEmpSalaryGreaterThan(13000.0);

        // custom query

        service.getAllEmpsCustom();

        service.getAllEmpsWithNameCustom("Deep");
	}

}
