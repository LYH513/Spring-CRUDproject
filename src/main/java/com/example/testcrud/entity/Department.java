package com.example.testcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 모든 필드를 포함하는 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
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
}
