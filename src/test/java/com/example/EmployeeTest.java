package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angela Gustafsson, anggus-1
 */
class EmployeeTest {

    @Test
    void getId() {
        Employee employee = new Employee("", 0.1);
        assertEquals("", employee.getId());

    }

    @Test
    void setId() {
        Employee employee = new Employee("", 0.1);
        employee.setId("Tant lur");
        assertEquals("Tant lur", employee.getId());
    }

    @Test
    void getSalary() {
        Employee employee = new Employee("", 10000.1);
        assertEquals(10000.1, employee.getSalary());
    }

    @Test
    void setSalary() {
        Employee employee = new Employee("", 12000.8);
        employee.setSalary(75000.1);
        assertEquals(75000.1, employee.getSalary());
    }

    @Test
    void isPaid() {
        Employee employee = new Employee("", 10000.1);
        assertFalse(employee.isPaid());
    }

    @Test
    void setPaid() {
        Employee employee = new Employee("", 10000.1);
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void testToString() {
        Employee employee = new Employee("Tant Lur", 10000.1);
        String expected = "Employee [id=" + "Tant Lur"  + ", salary=" + 10000.1 + "]";
        assertEquals(expected, employee.toString());
    }
}