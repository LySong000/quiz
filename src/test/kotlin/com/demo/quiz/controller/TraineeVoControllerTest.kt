package com.demo.quiz.controller

import com.demo.quiz.dto.TraineeDto
import com.demo.quiz.service.TraineeService
import com.demo.quiz.vo.TraineeVo
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest
class TraineeVoControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var traineeService: TraineeService

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    internal fun should_save_trainee() {
        val traineeDto = TraineeDto()
        traineeDto.name = "Tom"
        val expected = TraineeVo()
        expected.id = 1
        BeanUtils.copyProperties(traineeDto, expected)
        `when`(traineeService.create(any())).thenReturn(expected)
        val create = traineeService.create(traineeDto)
        println(create.toString())
        mockMvc.post("/trainees") {
            content = objectMapper.writeValueAsBytes(traineeDto)
            contentType = APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { string(objectMapper.writeValueAsString(expected)) }
        }
    }
}