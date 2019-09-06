package com.tavisca.workshops.RESTfulWebServiceWithSpring.model;

public class Employee {
    private String employeeID;
    private String employeeName;
    private String employeeProfile;

    Employee (String employeeID, String employeeName, String employeeProfile) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeProfile = employeeProfile;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String getEmployeeProfile() {
        return this.employeeProfile;
    }
}
