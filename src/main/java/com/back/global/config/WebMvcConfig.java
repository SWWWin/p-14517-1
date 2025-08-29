package com.back.global.config;

import com.back.global.interceptor.BeforeActionInterceptor;
import com.back.global.interceptor.NeedToLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final BeforeActionInterceptor beforeActionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration;
        registration = registry.addInterceptor(beforeActionInterceptor);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/resources/**");
        registration.excludePathPatterns("/error");
        registration.excludePathPatterns("/favicon.ico");

        registration = registry.addInterceptor(needToLoginInterceptor);
        registration.addPathPatterns("/posts/write");
    }

    private final NeedToLoginInterceptor needToLoginInterceptor;
}
