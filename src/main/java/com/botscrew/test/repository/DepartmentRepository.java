package com.botscrew.test.repository;


import com.botscrew.test.model.Degree;
import com.botscrew.test.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
