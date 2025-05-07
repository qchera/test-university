package com.botscrew.test.service;

public interface UniversityService {

    String findDepartmentHead(String departmentName);

    String findDepartmentStats(String departmentName);

    String findAverageSalaryByDepartment(String departmentName);

    String findEmployeeCountByDepartment(String departmentName);

    String globalSearchByName(String name);
}
