package com.university.botscrew.service;

import java.util.Map;

public interface DepartmentService {
    String getDepartmentHead(String departmentName);

    Map<String, Long> getDepartmentStatistic(String departmentName);

    double getAverageDepartmentSalary(String departmentName);

    int getDepartmentEmployeeCount(String departmentName);
}
