package com.busramestan.firstSpringBoot.repository;

import com.busramestan.firstSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameContaining(String firstName);

    List<Employee> findByDepartmentIgnoreCase(String department);

    @Query("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> listRichEmployees(@Param("amount") Double amount);

    @Query(value = "SELECT * FROM employees WHERE hobby = :hobby", nativeQuery = true)
    List<Employee> listEmployeesByHobby(@Param("hobby") String hobby);
}
