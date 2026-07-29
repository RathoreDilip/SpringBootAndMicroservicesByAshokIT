package com.ashokit;

import com.ashokit.entity.Employee;
import com.ashokit.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeRepository bean = context.getBean(EmployeeRepository.class);
		System.out.println("Implementation proxy class created by data JPA: "+bean.getClass().getName()); // jdk.proxy2.$Proxy109

//		Method[] methods = bean.getClass().getMethods();
//		System.out.println("Methods : "+ Arrays.toString(methods));
//		for (int i = 0; i < methods.length; i++) {
//			System.out.println(methods[i]);
//		}

		Employee employee=new Employee(3,"Deep",13000.00);
		bean.save(employee); // upsert method
		System.out.println("Record inserted : "+employee.toString());

		Optional<Employee> byId = bean.findById(2);
		if(byId.isPresent())
			System.out.println("record present : "+byId.get());

//		bean.deleteById(1);
//		System.out.println("Record deleted : "+bean.findById(1));



	}

}
