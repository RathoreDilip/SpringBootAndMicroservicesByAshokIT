package com.ashokit.repository;

import com.ashokit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    // select * from employee where emp_name='Aman';
    public List<Employee> findByEmpName(String name);     // abstract method - no body

    // select * from employee where emp_salary=77000;
    public List<Employee> findByEmpSalary(Double salary);

    // select * from employee where emp_name='Aman' and emp_salary=77000;
    public List<Employee> findByEmpNameAndEmpSalary(String name,Double salary);

    // select * from employee where emp_salary > 13000;
    public List<Employee> findByEmpSalaryGreaterThan(Double salary);

//    public List<Employee> findByEmpSalaryGrea(Double salary);


    // ------- custom query example -----------
    // HQL
    @Query("from Employee")
    public List<Employee> getAllEmpsHql();

    // SQL
    @Query(value = "select * from employee",nativeQuery = true)
    public List<Employee> getAllEmpsSql();

    // HQL
    @Query("from Employee where empName=:name")
    public List<Employee> getEmpsWithNameHql(String name);

}
