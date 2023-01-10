package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class UpdateEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/edit/{empID}")
    public ModelAndView showUpdateForm(@PathVariable("empID") int empID) {
        ModelAndView modelAndView = new ModelAndView("invalidView");
        Employee employee = this.employeeService.findEmployeeByID(empID);
        if(employee!=null){
            modelAndView.setViewName("editEmployeeView");
            modelAndView.addObject("employee", employee);
        }
        return modelAndView;
    }

    @PostMapping("/edit/{empID}")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("confirmView");
        modelAndView.addObject("employeeModel", employee);
        this.employeeService.saveEmployee(employee);
        return modelAndView;
    }
}
