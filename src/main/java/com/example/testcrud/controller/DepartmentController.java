package com.example.testcrud.controller;

import com.example.testcrud.dto.DefaultDto;
import com.example.testcrud.dto.DepartmentDto;
import com.example.testcrud.entity.Department;
import com.example.testcrud.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public DefaultDto.ResDto saveDepartment(
            @RequestBody DepartmentDto.CreateDepartment department) {
        // @Valid : 입력된 데이터(객체)에 대해 유효성 검사를 수행하는 어노테이션
        System.out.println("POST 요청 들어옴");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<DepartmentDto.DetailResDto> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public DepartmentDto.DetailResDto fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@RequestBody DepartmentDto.UpdateReqDto department, @PathVariable("id") Long departmentId) {
         departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentByID(departmentId);
        return "Deleted Successfully";
    }
}
