package com.jpa.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.jpa.test.model")
public class DatabaseConfiguration {
}
