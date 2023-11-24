package com.construction.systems.constech.task.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TaskMapper studentMapper() {
        return new TaskMapper();
    }
}
