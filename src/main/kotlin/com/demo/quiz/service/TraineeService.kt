package com.demo.quiz.service

import com.demo.quiz.dto.TraineeDto
import com.demo.quiz.entity.Trainee
import com.demo.quiz.repository.TraineeRepository
import com.demo.quiz.vo.TraineeVo
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TraineeService {

    @Autowired
    private lateinit var traineeRepository: TraineeRepository

    fun create(traineeDto: TraineeDto): TraineeVo {
        val trainee = Trainee()
        BeanUtils.copyProperties(traineeDto, trainee)
        traineeRepository.save(trainee)
        val traineeVo = TraineeVo()
        BeanUtils.copyProperties(trainee, traineeVo)
        return traineeVo
    }

}
