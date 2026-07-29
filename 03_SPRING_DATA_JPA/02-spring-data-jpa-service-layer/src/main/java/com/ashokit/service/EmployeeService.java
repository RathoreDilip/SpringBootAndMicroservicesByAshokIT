package com.ashokit.service;

import com.ashokit.entity.Employee;
import com.ashokit.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        System.out.println("EmployeeService() param constructor is called...");
        this.employeeRepository=employeeRepository;
    }

    public void saveEmployee(){
        Employee employee=new Employee();
        employee.setEmpId(102);
        employee.setEmpName("Aman");
        employee.setEmpSalary(77000.0);

        employeeRepository.save(employee);
    }

    public void getAllEmployee(){
        Iterable<Employee> emps = employeeRepository.findAll();
        emps.forEach(System.out::println); // method reference

        // lambda expression
        emps.forEach(e->{
            System.out.println(e);
        });

        // for each loop
        for (Employee employee:emps){
            System.out.println(employee);
        }

        // iterator
        Iterator<Employee> iterator = emps.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            System.out.println("Emp : "+emp);
        }
    }

    public void getFindAllByIdEmployee(){
        Iterable<Employee> allById = employeeRepository.findAllById(Arrays.asList(1, 2, 3));

        System.out.println("Find All By Id Employee");
        for (Employee employee:allById){
            System.out.println(employee);
        }

    }

    public void findByEmpName(String name){
        List<Employee> byEmpName = employeeRepository.findByEmpName(name);
        System.out.println("--- findByEmpName ------");
        System.out.println(byEmpName);
    }

    public void findByEmpSalary(Double empSalary){
        List<Employee> listOfEmp = employeeRepository.findByEmpSalary(empSalary);
        System.out.println("--- findByEmpSalary ------");
        System.out.println(listOfEmp);
    }

    public void findByEmpNameAndEmpSalary(String name,Double salary){
        List<Employee> byEmpNameAndEmpSalary = employeeRepository.findByEmpNameAndEmpSalary(name, salary);
        System.out.println("--- findByEmpNameAndEmpSalary ------");
        System.out.println(byEmpNameAndEmpSalary);
    }

    public void findByEmpSalaryGreaterThan(Double salary){
        List<Employee> byEmpSalaryGreaterThan = employeeRepository.findByEmpSalaryGreaterThan(salary);
        System.out.println("--- findByEmpSalaryGreaterThan ------");
        System.out.println(byEmpSalaryGreaterThan);
    }

    public void getAllEmpsCustom(){
        System.out.println("---- getAllEmpsCustom ----");
        List<Employee> allEmpsHql = employeeRepository.getAllEmpsHql();
        List<Employee> allEmpsSql = employeeRepository.getAllEmpsSql();
        System.out.println("-- HQL --");
        allEmpsHql.forEach(System.out::println);
        System.out.println("-- SQL --");
        allEmpsSql.forEach(System.out::println);
    }

    public void getAllEmpsWithNameCustom(String name){
        System.out.printf("---- getEmpsWithNameHql ----");
        List<Employee> empsWithNameHql = employeeRepository.getEmpsWithNameHql(name);
        empsWithNameHql.forEach(System.out::println);
    }


}
