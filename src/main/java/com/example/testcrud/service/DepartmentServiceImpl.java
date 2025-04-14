package com.example.testcrud.service;

import com.example.testcrud.dto.DefaultDto;
import com.example.testcrud.dto.DepartmentDto;
import com.example.testcrud.entity.Department;
import com.example.testcrud.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DefaultDto.ResDto saveDepartment(DepartmentDto.CreateDepartment department){
        return departmentRepository.save(department.toEntity()).toCreateResDto();
    }

    @Override
    public List<DepartmentDto.DetailResDto> fetchDepartmentList(){
        List<Department> list = (List<Department>) departmentRepository.findAll(); // 1. 전체 부서 엔티티 조회
        List<DepartmentDto.DetailResDto> dtoList = new ArrayList<>();
        for(Department each : list){
            dtoList.add(fetchDepartmentById(each.getDepartmentId()));
        }
        return dtoList;
    }

    @Override
    public DepartmentDto.DetailResDto fetchDepartmentById(Long departmentId){
        Department department = departmentRepository.findById(departmentId).orElse(null);
        DepartmentDto.DetailResDto detailResDto = DepartmentDto.DetailResDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentCode(department.getDepartmentCode())
                .departmentName(department.getDepartmentName())
                .departmentAddress(department.getDepartmentAddress())
                .build();

        return detailResDto;
    }

    @Override
    public void updateDepartment(DepartmentDto.UpdateReqDto department,
                                 Long departmentId){
        Department depDB = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(
                department.getDepartmentName())){

            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(
                        department.getDepartmentAddress())){

            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(
                        department.getDepartmentCode())){

            depDB.setDepartmentCode(department.getDepartmentCode());
        }


        // save : 엔티티가 존재하면 업데이트, 존재하지 않으면 새로 생성.
        departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentByID(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
