package co.pitam.bservice.config;

import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshot;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//@Configuration(proxyBeanMethods = false)
public class AsyncTraceContextConfig implements AsyncConfigurer, WebMvcConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        return ContextExecutorService.wrap(Executors.newCachedThreadPool(), ContextSnapshot::captureAll);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new SimpleAsyncTaskExecutor(r -> new Thread(ContextSnapshot.captureAll().wrap(r))));
    }

}
