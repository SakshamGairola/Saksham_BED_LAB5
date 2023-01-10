package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;


    //homeView -> list all employees
    @GetMapping("")
    public ModelAndView showAllEmployees(Model model) {
        List<Employee> employees = this.employeeService.getAllEmployees();
        Map<String, List<Employee>> map = new HashMap<>();
        map.put("empList", employees);
        return new ModelAndView("homeView", map);
    }



    @PostMapping("/confirm")
    public ModelAndView test(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("confirmView");
        System.out.println(employee);
        this.employeeService.saveEmployee(employee);
        modelAndView.addObject("employeeModel", employee);
        return modelAndView;
    }
}
