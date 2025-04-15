package com.example.testcrud.dto;

import com.example.testcrud.entity.Department;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class DepartmentDto {

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateReq {
        String departmentName;
        String departmentAddress;
        String departmentCode;

        public Department toEntity() {return Department.getDepartment(
                null,
                getDepartmentName(),
                getDepartmentAddress(),
                getDepartmentCode()); }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends DefaultDto.ReqDto{
        String departmentName;
        String departmentAddress;
        String departmentCode;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends DefaultDto.ResDto{
        String departmentName;
        String departmentAddress;
        String departmentCode;
    }
}
