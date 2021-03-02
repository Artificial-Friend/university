package com.university.botscrew.service.implementation;

import com.university.botscrew.model.Employee;
import com.university.botscrew.repository.EmployeeRepository;
import com.university.botscrew.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAny(String input) {
        return employeeRepository.findAllByNameRegex(input);
    }
}
