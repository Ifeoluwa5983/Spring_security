package com.security.springSecurity.data.repository;

import com.security.springSecurity.data.models.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void createTastTest(){
        Task myTask = Task.builder()
                .name("clean the toilet")
                .type("cleaning")
                .status("active")
                .build();

        log.info("Task object created -> {}" , myTask);
        taskRepository.save(myTask);
        assertThat(myTask.getId()).isNotNull();
        log.info("Task object after saving -> {}", myTask);
    }
}