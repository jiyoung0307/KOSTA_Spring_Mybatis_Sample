package com.example.sample.controller;

import com.example.sample.domain.Score;
import com.example.sample.domain.Student;
import com.example.sample.repository.ScoreRepository;
import com.example.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final ScoreRepository scoreRepository;

    @Autowired
    public StudentController(StudentService studentService,
                             ScoreRepository scoreRepository) {
        this.studentService = studentService;
        this.scoreRepository = scoreRepository;
    }

    @GetMapping
    public String getAllStudents(Model model){
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("students",allStudents);
        return "student/studentList";
    }

    @GetMapping("/studentInfo/{id}")
    public String getAllStudents(@PathVariable int id,  Model model){
        Student studentInfo = studentService.getStudentInfo(id);
        model.addAttribute("student",studentInfo);
        return "student/studentInfo";
    }

    @GetMapping("/studentUpdate/{id}")
    public String updateScore(@PathVariable int id,  Model model){
        Student studentInfo = studentService.getStudentInfo(id);
        Score score = scoreRepository.findById(id);  // 점수 없는 경우만 입력한다
        System.out.println("score null ? " + score);
        if(score == null) {
            model.addAttribute("student", studentInfo);
            return "student/studentUpdateForm";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/updateScore/{id}")
    public String updateScore(@PathVariable int id,
                              @ModelAttribute Score score){
        Student studentInfo = studentService.getStudentInfo(id);
        System.out.println(score.getId() + ":" + score.getSPoint());
        scoreRepository.addScore(score);
        studentService.updateStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/addStudent")
    public String addNewStudent(){
        return "student/studentForm";
    }

    @PostMapping("/addStudent")
    public String addNewStudent(@ModelAttribute Student student){
        studentService.addNewStudent(student);
        return "redirect:/students";
    }
}