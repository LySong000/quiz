package com.demo.quiz.repository

import com.demo.quiz.entity.Trainee
import com.demo.quiz.vo.TraineeVo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TraineeRepository: JpaRepository<Trainee, Long>{

}
