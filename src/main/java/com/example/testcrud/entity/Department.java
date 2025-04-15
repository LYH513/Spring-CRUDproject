package com.example.testcrud.entity;

import com.example.testcrud.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data //Getter, Setter, toString, equals 등 자동 생성
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    protected  Department(){}

    private Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    // Entity의 인스턴스를 만들 때 무조건 getDepartment 메서드를 통해 만들 수 있도록
    public static Department getDepartment(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        return new Department(departmentId, departmentName, departmentAddress, departmentCode);
    }

    public DefaultDto.ResDto toCreateResDto() {
        return DefaultDto.ResDto.builder().departmentId(getDepartmentId()).build();
    }
}
