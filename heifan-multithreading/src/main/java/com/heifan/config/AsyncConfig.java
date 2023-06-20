package com.heifan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        executor.setCorePoolSize(10);
        // 最大线程池大小
        executor.setMaxPoolSize(50);
        // 队列容量
        executor.setQueueCapacity(100);
        // 线程名称前缀
        executor.setThreadNamePrefix("MyThread-");
        executor.initialize();
        return executor;
    }
}
