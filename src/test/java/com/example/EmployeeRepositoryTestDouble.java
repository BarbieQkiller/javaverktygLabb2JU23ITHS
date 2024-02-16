package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class EmployeeRepositoryTestDouble implements EmployeeRepository{
    private List<Employee> employees = new ArrayList<>();
    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        employees.add(e);
        return e;
    }
}
