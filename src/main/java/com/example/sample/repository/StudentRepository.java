package com.example.sample.repository;

import com.example.sample.model.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> selectAll();
    Student selectById(int studentId);
    Student regist(Student student);
    Student update(int studentId, Student student);
    Student delete(int studentId);

}
