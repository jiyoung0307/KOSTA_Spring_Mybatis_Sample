package com.example.sample.service;

import com.example.sample.domain.Score;
import com.example.sample.repository.ScoreRepository;
import com.example.sample.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public Score getStudentScore(int id){
        return scoreRepository.findById(id);
    }

    public int addStudentScore(Score score){
        return scoreRepository.addScore(score);
    }
}