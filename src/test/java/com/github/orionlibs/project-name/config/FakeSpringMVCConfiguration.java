package com.github.orionlibs.project-name.config;

import com.github.orionlibs.project-name.NewClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =
                {"com.github.orionlibs"})
public class FakeSpringMVCConfiguration
{
    @Bean
    public NewClass newClass()
    {
        return new NewClass();
    }
}
