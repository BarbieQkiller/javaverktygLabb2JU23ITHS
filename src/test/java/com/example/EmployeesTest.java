package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angela Gustafsson, anggus-1
 */
class EmployeesTest {
    private EmployeeRepositoryTestDouble employeeRepository ;
    private BankServiceTestDouble bankService ;
    private Employees employees ;
    @BeforeEach
    void beforeEach() {
        employeeRepository = new EmployeeRepositoryTestDouble();
        bankService = new BankServiceTestDouble();
        employees = new Employees(employeeRepository, bankService);

    }
    @Test
    @DisplayName("Successfully pay employees")
    void payEmployeesSuccessful() {
        employeeRepository.save(new Employee("Tant Lur", 10000.0));


        int paid = employees.payEmployees();

        assertEquals(1, paid);
        assertTrue(employeeRepository.findAll().get(0).isPaid());

    }
    @Test
    @DisplayName("Fail to pay employees")
    void payEmployeesUnsuccessful() {
        employeeRepository.save(new Employee("Farbror", 10000.0));

        int paid = employees.payEmployees();

        assertEquals(0, paid);
        assertFalse(employeeRepository.findAll().get(0).isPaid());
    }
}