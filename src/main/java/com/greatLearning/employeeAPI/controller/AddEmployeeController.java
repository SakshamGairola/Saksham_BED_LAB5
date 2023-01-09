package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class AddUserController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/new")
    public ModelAndView showAddEmployeeForm(Employee employee){
        ModelAndView modelAndView = new ModelAndView("createNewEmployeeView");
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView addEmployee(@ModelAttribute Employee employee){
        ModelAndView modelAndView = new ModelAndView("confirmView");
        this.employeeService.saveEmployee(employee);
        modelAndView.addObject("employeeModel", employee);
        return modelAndView;
    }

}
