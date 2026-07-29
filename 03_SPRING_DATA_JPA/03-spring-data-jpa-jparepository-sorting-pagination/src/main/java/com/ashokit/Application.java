package com.ashokit;

import com.ashokit.entity.Employee;
import com.ashokit.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        EmployeeService employeeServiceBean = context.getBean(EmployeeService.class);
        // sort
        employeeServiceBean.findAllEmp();

        // pagination
        employeeServiceBean.getEmpPage(3);

        // Query By Example
        Employee employee=new Employee();
        employee.setEmpName("Deep");
        employee.setEmpSalary(13000.0);

        employeeServiceBean.getEmpsWithQBE(employee);

    }

}
