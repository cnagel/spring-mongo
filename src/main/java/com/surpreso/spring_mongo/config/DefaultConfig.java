package com.surpreso.spring_mongo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The default configuration loading the Spring Boot context.
 * 
 * @author Christoph Nagel
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.surpreso.spring_mongo")
public class DefaultConfig {

}