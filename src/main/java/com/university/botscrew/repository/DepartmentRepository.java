package com.university.botscrew.repository;

import com.university.botscrew.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByNameIgnoreCase(String department);
}
