package com.tavisca.workshops.RESTfulWebServiceWithSpring.service;

import com.tavisca.workshops.RESTfulWebServiceWithSpring.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EmployeeServices {
    private static ArrayList<Employee> employees = new ArrayList<>();

    static {
        //Initialize Data
        Employee employee1 = new Employee("1127", "Varun Nayal", "Software Trainee");
        Employee employee2 = new Employee("1117", "Shubham Singh", "Software Trainee");
        Employee employee3 = new Employee("1073", "Ayush Verma", "Software Trainee");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    public Employee addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee getDetailsOfAnEmployee(String employeeID) {
        for (Employee employee: employees) {
            if(employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getDetailsOfAllEmployees() {
        return employees;
    }

    public ArrayList<Employee> deleteRecordsOfAllEmployees() {
        employees.clear();
        return employees;
    }

    public ArrayList<Employee> deleteRecordOfAnEmployee(String employeeID) {
        for (Employee employee: employees
             ) {
            if(employee.getEmployeeID().equals(employeeID)) {
                employees.remove(employee);
                break;
            }
        }
        return employees;
    }
}
