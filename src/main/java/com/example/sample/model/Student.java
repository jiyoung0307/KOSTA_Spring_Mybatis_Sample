package com.example.sample.model;

import lombok.Data;

// 비즈니스 도메인
@Data
public class Student {
    private int studentId;
    private String name;
    private String major;
    private float point;
}
