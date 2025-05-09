package com.botscrew.test.service.impl;

import com.botscrew.test.model.Degree;
import com.botscrew.test.model.Department;
import com.botscrew.test.model.Lecturer;
import com.botscrew.test.repository.DepartmentRepository;
import com.botscrew.test.repository.LecturerRepository;
import com.botscrew.test.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private DepartmentRepository departmentRepository;

    private LecturerRepository lecturerRepository;

    @Override
    @Transactional(readOnly = true)
    public String findDepartmentHead(String departmentName) {
        Department department = departmentRepository.findByName(departmentName)
                                                    .orElseThrow(() -> new IllegalArgumentException("Department '" + departmentName + "' not found"));
        return String.format("Head of %s department is %s",
                             departmentName, department.getHead().getName());
    }

    @Override
    @Transactional(readOnly = true)
    public String findDepartmentStats(String departmentName) {
        Department department = departmentRepository.findByName(departmentName)
                                                    .orElseThrow(() -> new IllegalArgumentException("Department '" + departmentName + "' not found"));
        AtomicInteger assistants = new AtomicInteger();
        AtomicInteger associates = new AtomicInteger();
        AtomicInteger professors = new AtomicInteger();

        department.getLecturers().forEach(l -> {
            switch(l.getDegree()) {
                case Degree.ASSISTANT -> assistants.incrementAndGet();
                case Degree.ASSOCIATE_PROFESSOR -> associates.incrementAndGet();
                case Degree.PROFESSOR -> professors.incrementAndGet();
            }
        });
        return String.format("assistants - %d; associate professors - %d; professors - %d",
                             assistants.get(), associates.get(), professors.get());
    }

    @Override
    @Transactional(readOnly = true)
    public String findAverageSalaryByDepartment(String departmentName) {
        Department department = departmentRepository.findByName(departmentName)
                                                    .orElseThrow(() -> new IllegalArgumentException("Department '" + departmentName + "' not found"));
        BigDecimal sum = department.getLecturers().stream()
                .map(Lecturer::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        int count = department.getLecturers().size();
        BigDecimal avgSalary = count > 0 ? sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;

        return String.format("The average salary of %s is %s",
                                    departmentName, avgSalary);
    }

    @Override
    @Transactional(readOnly = true)
    public String findEmployeeCountByDepartment(String departmentName) {
        Department department = departmentRepository.findByName(departmentName)
                                                    .orElseThrow(() -> new IllegalArgumentException("Department '" + departmentName + "' not found"));
        return String.valueOf(department.getLecturers().size());
    }

    @Override
    @Transactional(readOnly = true)
    public String globalSearchByName(String name) {
        List<Lecturer> lecturers = lecturerRepository.findByNameContainingIgnoreCase(name);
        return lecturers.stream()
                .map(Lecturer::getName)
                .collect(Collectors.joining(", "));
    }
}
