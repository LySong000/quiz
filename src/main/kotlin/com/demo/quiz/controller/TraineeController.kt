package com.demo.quiz.controller

import com.demo.quiz.dto.TraineeDto
import com.demo.quiz.service.TraineeService
import com.demo.quiz.vo.Trainee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/trainees")
class TraineeController {

    @Autowired
    private lateinit var traineeService: TraineeService

    @PostMapping
    fun create(@RequestBody traineeDto: TraineeDto): Trainee {
        return traineeService.create(traineeDto)
    }
}
