package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("api/v1/student/add")  // Allow CORS for specific endpoints (e.g., /api/v1/student/add)
                .allowedOrigins("http://localhost:3000")  // Specify the allowed origin (your frontend application's URL)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed HTTP methods
                .allowCredentials(true);  // Allow credentials (e.g., cookies)
    }
}
