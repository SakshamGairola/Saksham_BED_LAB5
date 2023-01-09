package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class AddEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/new")
    public ModelAndView showAddEmployeeForm(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("createNewEmployeeView");
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("confirmView");
        modelAndView.addObject("employeeModel", employee);
        this.employeeService.saveEmployee(employee);
        return modelAndView;
    }
}
