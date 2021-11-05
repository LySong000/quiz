package com.demo.quiz.service

import com.demo.quiz.dto.TraineeDto
import com.demo.quiz.entity.Trainee
import com.demo.quiz.repository.TraineeRepository
import com.demo.quiz.vo.TraineeVo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class TraineeVoServiceTest {

    @MockBean
    private lateinit var traineeRepository: TraineeRepository

    @Autowired
    private lateinit var traineeService: TraineeService

    @Test
    internal fun should_create_trainee() {
        val traineeDto = TraineeDto().apply {
            name = "Tom"
        }
        val expected = Trainee().apply { id = 1 }
        BeanUtils.copyProperties(traineeDto, expected)
        `when`(traineeRepository.save(org.mockito.kotlin.any())).thenReturn(expected)
        val actual = traineeService.create(traineeDto)
        assertThat(actual.name).isEqualTo(expected.name)
    }
}

