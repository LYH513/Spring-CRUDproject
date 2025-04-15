package com.example.testcrud.mapper;

import com.example.testcrud.dto.DepartmentDto;

import java.util.List;

public interface DepartmentMapper {
    List<DepartmentDto.DetailResDto> fetchDepartmentList();
    DepartmentDto.DetailResDto fetchDepartmentById(Long departmentId);
}
