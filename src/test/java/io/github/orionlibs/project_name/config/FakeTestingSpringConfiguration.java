package io.github.orionlibs.project_name.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class FakeTestingSpringConfiguration
{
    @Configuration
    @Import(
                    {FakeSpringMVCConfiguration.class})
    @ComponentScan(basePackages =
                    {"io.github.orionlibs"})
    public static class FakeConfiguration
    {
    }
}