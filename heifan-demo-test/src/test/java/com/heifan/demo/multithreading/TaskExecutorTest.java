package com.heifan.demo.multithreading;

import com.heifan.demo.DemoApplicationTest;
import com.heifan.service.TaskExecutorTestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationArguments;;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

public class TaskExecutorTest extends DemoApplicationTest {

    @Resource
    TaskExecutorTestService taskExecutorTestService;
    @Test
    public void run() throws Exception {
        for (int i = 0; i < 50; i++) {
            taskExecutorTestService.longRunningMethod();
        }
    }
}
