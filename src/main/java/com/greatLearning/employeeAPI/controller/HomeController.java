package com.greatLearning.employeeAPI.controller;

import com.greatLearning.employeeAPI.model.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class HomeController {

    //homeView -> list all employees
    @GetMapping("")
    public ModelAndView homeView(Model model){
        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee(1, "Fname1","Lname1","email1"));
        emp.add(new Employee(2, "Fname2","Lname2","email2"));
        emp.add(new Employee(3, "Fname3","Lname3","email3"));
        emp.add(new Employee(4, "Fname4","Lname4","email4"));

        Map <String, List<Employee>>map = new HashMap<>();
        map.put("empList", emp);

        ModelAndView mav= new ModelAndView("default-View", map);
        return mav;
    }

    //creates new employee
    @GetMapping("/new")
    public ModelAndView createNewEmployee(){
        ModelAndView modelAndView = new ModelAndView("createNewEmployeeView");
        modelAndView.addObject(new Employee());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createNewEmployee2(){
        ModelAndView modelAndView = new ModelAndView("createNewEmployeeView");
        modelAndView.addObject(new Employee());
        return modelAndView;
    }

    @GetMapping("/edit/{empID}")
    public ModelAndView update(@PathVariable("empID") int empId){
        ModelAndView modelAndView = new ModelAndView("editEmployeeView");
        //get Employee obj from db
        Employee employee = new Employee();//getbyID();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(){
        return "delete";
    }

    @PostMapping("/confirm")
    public ModelAndView test(@ModelAttribute Employee employee){
        ModelAndView modelAndView = new ModelAndView("confirmView");
        //save the obj here
        //also update obj here
        modelAndView.addObject("employeeModel", employee);
        return modelAndView;
    }

}
