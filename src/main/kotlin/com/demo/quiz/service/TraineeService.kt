package com.demo.quiz.service

import com.demo.quiz.dto.TraineeDto
import com.demo.quiz.vo.Trainee
import org.springframework.stereotype.Service

@Service
class TraineeService {
    fun create(traineeDto: TraineeDto): Trainee {
        return Trainee()
    }

}
