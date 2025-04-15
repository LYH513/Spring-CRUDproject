package com.example.testcrud.service;

import com.example.testcrud.dto.DefaultDto;
import com.example.testcrud.dto.DepartmentDto;
import com.example.testcrud.entity.Department;

import java.util.List;

public interface DepartmentService {
    DefaultDto.ResDto saveDepartment(DepartmentDto.CreateReq department);
    List<DepartmentDto.DetailResDto> fetchDepartmentList();
    DepartmentDto.DetailResDto fetchDepartmentById(Long departmentId);
    void updateDepartment(DepartmentDto.UpdateReqDto department,
                                Long departmentId);
    void deleteDepartmentByID(Long departmentId);
}
