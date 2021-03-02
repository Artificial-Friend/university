package com.university.botscrew.service;

import com.university.botscrew.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAny(String input);
}
