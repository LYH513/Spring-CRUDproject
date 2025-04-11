package com.example.testcrud.service;

import com.example.testcrud.entity.Department;
import com.example.testcrud.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList(){
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department,
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
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentByID(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
