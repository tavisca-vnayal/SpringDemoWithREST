package com.tavisca.workshops.RESTfulWebServiceWithSpring.controller;

import com.tavisca.workshops.RESTfulWebServiceWithSpring.model.Employee;
import com.tavisca.workshops.RESTfulWebServiceWithSpring.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public String homePage() {
        return "<h1>Welcome, This is <u>EMPLOYEE MANAGEMENT SYSTEM</u></h1>";
    }

    @GetMapping("/employees")
    public ArrayList<Employee> fetchDetailsOfAllEmployees() {
       return employeeServices.getDetailsOfAllEmployees();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee fetchDetailsOfAnEmployee(@PathVariable String employeeID) {
        return employeeServices.getDetailsOfAnEmployee(employeeID);
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> enrollEmployee(
            @RequestBody Employee newEmployee) {

        Employee employee = employeeServices.addEmployee(newEmployee);

        if (employee == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(employee.getEmployeeID()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees")
    public ArrayList<Employee> deleteRecordsOfAllEmployees() {
        return employeeServices.deleteRecordsOfAllEmployees();
    }

    @DeleteMapping("/employees/{employeeID}")
    public ArrayList<Employee> deleteRecordOfAnEmployee(@PathVariable String employeeID) {
        System.out.println(employeeID);
        return employeeServices.deleteRecordOfAnEmployee(employeeID);
    }
}
