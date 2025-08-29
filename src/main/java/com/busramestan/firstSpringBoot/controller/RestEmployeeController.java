package com.busramestan.firstSpringBoot.controller;

import com.busramestan.firstSpringBoot.entity.Book;
import com.busramestan.firstSpringBoot.entity.Employee;
import com.busramestan.firstSpringBoot.entity.UpdateEmployeeRequest;
import com.busramestan.firstSpringBoot.service.BookService;
import com.busramestan.firstSpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/api/employee")
public class RestEmployeeController {
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
}

