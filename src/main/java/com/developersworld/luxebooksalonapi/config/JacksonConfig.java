package com.developersworld.luxebooksalonapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // Register custom deserializer for LocalTime
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

    @Bean
    public com.fasterxml.jackson.databind.Module javaTimeModule() {
        return new JavaTimeModule();
    }
}