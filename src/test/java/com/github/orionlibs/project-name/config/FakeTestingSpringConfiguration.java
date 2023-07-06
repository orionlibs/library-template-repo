package com.github.orionlibs.project-name.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class FakeTestingSpringConfiguration
{
    @Configuration
    @Import(
                    {FakeSpringMVCConfiguration.class})
    public static class FakeConfiguration
    {
    }
}