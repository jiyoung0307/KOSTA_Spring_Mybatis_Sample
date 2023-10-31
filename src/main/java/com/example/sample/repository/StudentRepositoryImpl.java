package com.example.sample.repository;

import com.example.sample.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static int seq = 0;

    @Override
    public List<Student> selectAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student selectById(int studentId) {
        Student student = studentMap.get(studentId);
        return student;
    }

    @Override
    public Student regist(Student student) {
        student.setStudentId(++seq);
        Student registStudent = studentMap.put(seq, student);
        return registStudent;
    }

    @Override
    public Student update(int studentId, Student student) {
        Student updateStudent = null;
        if(selectById(studentId) != null)
            updateStudent = studentMap.put(seq, student);
        else
            updateStudent = regist(student);
        return updateStudent;
    }

    @Override
    public Student delete(int studentId, Student student) {
        Student deleteStudent = studentMap.put(seq, student);
        return deleteStudent;
    }
}