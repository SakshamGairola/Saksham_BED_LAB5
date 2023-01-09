package com.greatLearning.employeeAPI.service;

import com.greatLearning.employeeAPI.model.Employee;

import java.util.List;

public interface EmployeeService {

    //update and save(insert and update)
    public Employee saveEmployee(Employee employee);

    //get all(view)
    public List<Employee> getAllEmployees();

    public Employee findEmployeeByID(int empID);

    public void deleteEmployee(Employee employee);
}
