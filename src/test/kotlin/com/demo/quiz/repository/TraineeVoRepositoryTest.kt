package com.demo.quiz.repository

import com.demo.quiz.entity.Trainee
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class TraineeVoRepositoryTest {

    @Autowired
    private lateinit var traineeRepository: TraineeRepository

    @Test
    internal fun should_create_trainee() {
        val trainee = Trainee().apply {
            name = "Tom"
        }
        val actual = traineeRepository.save(trainee)
        val excepted = Trainee().apply {
            id = 1
            name = "Tom"
        }
        assertThat(actual.name).isEqualTo(excepted.name)
    }
}