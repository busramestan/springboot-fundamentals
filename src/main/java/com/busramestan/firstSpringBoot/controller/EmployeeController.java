package com.busramestan.firstSpringBoot.controller;

import com.busramestan.firstSpringBoot.entity.Employee;
import com.busramestan.firstSpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(path = "/save")
    public Employee saveEmployee (@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEmployee(@PathVariable(name = "id") Long id){
         employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee updateEmployee){
        return employeeService.updateEmployee(id, updateEmployee);

    }
    @GetMapping(path = "/search-by-name")
    public List<Employee> findByFirstNameContaining(@RequestParam String firstName) {
        return employeeService.findByFirstNameContaining(firstName);
    }

    @GetMapping(path = "/search-by-department")
    public List<Employee> findByDepartmentIgnoreCase(@RequestParam String department){
        return employeeService.findByDepartmentIgnoreCase(department);
    }
}

