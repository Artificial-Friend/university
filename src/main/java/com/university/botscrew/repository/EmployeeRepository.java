package com.university.botscrew.repository;

import com.university.botscrew.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "FROM Employee e WHERE UPPER(e.name) LIKE UPPER(concat('%', concat(?1, '%')))")
    List<Employee> findAllByNameRegex(String regex);
}
