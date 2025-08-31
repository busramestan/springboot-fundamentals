package com.busramestan.firstSpringBoot.service;

import com.busramestan.firstSpringBoot.entity.Employee;
import com.busramestan.firstSpringBoot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        Employee dbEmployee = getEmployeeById(id);
        if(dbEmployee != null) {
            employeeRepository.delete(dbEmployee);
        }
    }

    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Employee dbEmployee = getEmployeeById(id);

        dbEmployee.setFirstName(updateEmployee.getFirstName());
        dbEmployee.setLastName(updateEmployee.getLastName());

        return employeeRepository.save(dbEmployee);
    }

    public List<Employee> findByFirstNameContaining(String firstName){
        return employeeRepository.findByFirstNameContaining(firstName);
    }

    public List<Employee> findByDepartmentIgnoreCase(String department){
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    public List<Employee> listRichEmployees(Double amount){
        return employeeRepository.listRichEmployees(amount);
    }

    public List<Employee> listEmployeesByHobby(String hobby){
        return employeeRepository.listEmployeesByHobby(hobby);
    }
}
