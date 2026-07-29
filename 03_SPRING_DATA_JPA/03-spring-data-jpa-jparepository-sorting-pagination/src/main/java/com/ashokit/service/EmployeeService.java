package com.ashokit.service;

import com.ashokit.entity.Employee;
import com.ashokit.repository.EmployeeRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private static final int pageSize=3;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    // sort
    public void findAllEmp(){
        System.out.println(" ---------- Sorting ------------- ");
        // List<Employee> all = empRepo.findAll();
        List<Employee> empNameList = employeeRepository.findAll(Sort.by("empId").ascending());
        empNameList.forEach(System.out::println);
    }

    // pagination
    public void getEmpPage(int pageNum){
        System.out.println(" ---------- Pagination ------------- ");
        Pageable page= PageRequest.of(pageNum - 1, pageSize);

        Page<Employee> emps = employeeRepository.findAll(page);

        emps.get().forEach(System.out::println);
    }

    // Filter - Query By Example
    public void getEmpsWithQBE(Employee emp){
        System.out.println(" ---------- Query By Example ------------- ");
        Example<Employee> employeeExample = Example.of(emp);

        List<Employee> employees = employeeRepository.findAll(employeeExample);

        employees.forEach(System.out::println);

    }


}
