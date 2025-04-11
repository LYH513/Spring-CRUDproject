package com.example.testcrud.service;

import com.example.testcrud.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department fetchDepartmentById(Long departmentId);
    Department updateDepartment(Department department,
                                Long departmentId);
    void deleteDepartmentByID(Long departmentId);
}
