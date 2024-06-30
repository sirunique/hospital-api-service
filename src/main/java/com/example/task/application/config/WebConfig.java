package com.example.task.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.task.application.interceptor.StaffUuidInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final StaffUuidInterceptor staffUuidInterceptor;

    public WebConfig(StaffUuidInterceptor staffUuidInterceptor) {
        this.staffUuidInterceptor = staffUuidInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(staffUuidInterceptor).addPathPatterns("/api/patients/**");
    }
}
