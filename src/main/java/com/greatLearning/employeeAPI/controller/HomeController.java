package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import com.greatLearning.employeeAPI.service.EmployeeService;
import com.greatLearning.employeeAPI.serviceImpl.EmployeeServiceImpl;
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
    EmployeeService employeeService;


    //homeView -> list all employees
    @GetMapping("")
    public ModelAndView homeView(Model model) {
        List<Employee> employees = this.employeeService.getAllEmployees();
        Map<String, List<Employee>> map = new HashMap<>();
        map.put("empList", employees);
        return new ModelAndView("homeView", map);
    }

    //creates new employee
    @GetMapping("/new")
    public ModelAndView createNewEmployee() {
        ModelAndView modelAndView = new ModelAndView("createNewEmployeeView");
        modelAndView.addObject(new Employee());
        return modelAndView;
    }

    @GetMapping("/delete/{empID}")
    public ModelAndView delete(@PathVariable("empID") int empId){
        ModelAndView modelAndView = new ModelAndView("deleteView");
        Employee deletedEmployee = this.employeeService.findEmployeeByID(empId);
        this.employeeService.deleteEmployee(deletedEmployee);
        modelAndView.addObject("deletedEmployee", deletedEmployee);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public ModelAndView test(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("confirmView");
        //save the obj here
        //also update obj here
//        this.employeeService.saveEmployee(employee);
        System.out.println(employee);
        modelAndView.addObject("employeeModel", employee);
        return modelAndView;
    }

    @GetMapping("/edit/{empID}")
    public ModelAndView update(@PathVariable("empID") int empId) {
        ModelAndView modelAndView = new ModelAndView("editEmployeeView");
        Employee employee = this.employeeService.findEmployeeByID(empId);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    /*
    * add empID in update employee submit URL
    * get that in path VAR in confirm method
    * then update the object
    * */
}
