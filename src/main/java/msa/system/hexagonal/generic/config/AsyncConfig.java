package msa.system.hexagonal.generic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfig {

    private final int CORE_POOL_SIZE = 1;
    private final int MAX_POOL_SIZE = 1;
    private final int QUEUE_CAPACITY = 1;
    private final String ASYNC_THREAD_NAME_PREFIX = "async-thread-";

    @Bean
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.setThreadNamePrefix(ASYNC_THREAD_NAME_PREFIX);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
