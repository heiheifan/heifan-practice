package com.heifan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

@Slf4j
@Service
public class TaskExecutorTestService {

    @Autowired
    Executor taskExecutor;

    @Async("taskExecutor")
    public void longRunningMethod() {
        int i = 0;
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100; j++) {
                    log.info("xxxxxxxxx {}-[{}]", Thread.currentThread().getName(), j);
                }
            }
        });

    }
}
