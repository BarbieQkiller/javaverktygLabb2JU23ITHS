package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angela Gustafsson, anggus-1
 */
class EmployeesTest {
private EmployeeRepositoryTestDouble employeeRepository = new EmployeeRepositoryTestDouble();
private BankServiceTestDouble bankService = new BankServiceTestDouble();
private Employees employees = new Employees(employeeRepository, bankService);
    @Test
    void payEmployees() {
        employeeRepository.save(new Employee("Tant Lur", 10000.0));
        employeeRepository.save(new Employee("Farbror", 10000.0));

        int paid = employees.payEmployees();

        assertEquals(1, paid);
        assertTrue(employeeRepository.findAll().get(0).isPaid());
        assertFalse(employeeRepository.findAll().get(1).isPaid());
    }
}