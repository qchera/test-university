package com.botscrew.test.repository;


import com.botscrew.test.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    List<Lecturer> findByNameContainingIgnoreCase(String template);
}
