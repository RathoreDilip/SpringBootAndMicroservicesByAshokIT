package com.ashokit.service;

import com.ashokit.entity.Address;
import com.ashokit.entity.Employee;
import com.ashokit.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void fetchEmployeeById(){
        employeeRepository.findById(1);
    }

    public void saveEmployeeWithAddress(){

        Employee employee=new Employee();
        employee.setEmpName("Dilip");
        employee.setEmpSalary("90000");

        Address address1=new Address();
        address1.setCity("Surat");
        address1.setState("Gujarat");
        address1.setCountry("India");
        address1.setType("Permanent");

        Address address2=new Address();
        address2.setCity("Pune");
        address2.setState("Maharashtra");
        address2.setCountry("India");
        address2.setType("Temporary");

        // associate emp object to address objects
        address1.setEmployee(employee);
        address2.setEmployee(employee);

        // associates address object with emp objects
        employee.setAddresses(List.of(address1,address2));

        // save emp
        employeeRepository.save(employee);

    }

}
