package com.university.botscrew.service.implementation;

import com.university.botscrew.model.Department;
import com.university.botscrew.model.Employee;
import com.university.botscrew.repository.DepartmentRepository;
import com.university.botscrew.service.DepartmentService;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public String getDepartmentHead(String departmentName) {
        return getDepartmentIgnoreCase(departmentName).getHead().getName();
    }

    public Map<String, Long> getDepartmentStatistic(String departmentName) {
        Department department = getDepartmentIgnoreCase(departmentName);
        Map<String, Long> statistic = new HashMap<>();
        department.getEmployees().forEach(employee -> statistic.put(employee.getDegree().name(),
                statistic.get(employee.getDegree().name()) == null ? 1L
                        : statistic.get(employee.getDegree().name()) + 1L));
        return statistic;
    }

    public double getAverageDepartmentSalary(String departmentName) {
        return getDepartmentIgnoreCase(departmentName).getEmployees().stream()
                .mapToInt(Employee::getSalary)
                .summaryStatistics()
                .getAverage();
    }

    public int getDepartmentEmployeeCount(String departmentName) {
        return getDepartmentIgnoreCase(departmentName).getEmployees().size();
    }

    private Department getDepartmentIgnoreCase(String name) {
        return departmentRepository.findDepartmentByNameIgnoreCase(name);
    }
}
