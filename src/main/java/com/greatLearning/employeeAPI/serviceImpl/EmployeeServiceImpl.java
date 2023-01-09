package com.greatLearning.employeeAPI.serviceImpl;

import com.greatLearning.employeeAPI.dao.EmployeeRepository;
import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByID(int empID){ return this.employeeRepository.findById(empID).get();}

    @Override
    public void deleteEmployee(Employee employee) { this.employeeRepository.delete(employee); }

}
