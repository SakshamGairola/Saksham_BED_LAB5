package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class DeleteEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/delete/{empID}")
    public ModelAndView delete(@PathVariable("empID") int empId) {
        ModelAndView modelAndView = new ModelAndView("invalidView");
        Employee deletedEmployee = this.employeeService.findEmployeeByID(empId);
        if (deletedEmployee != null) {
            this.employeeService.deleteEmployee(deletedEmployee);
            modelAndView.setViewName("deleteView");
            modelAndView.addObject("deletedEmployee", deletedEmployee);
        }
        return modelAndView;
    }
}
