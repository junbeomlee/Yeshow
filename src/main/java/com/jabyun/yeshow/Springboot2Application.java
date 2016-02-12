package com.jabyun.yeshow;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication // -> Configuration, EnableAutoConfiguration, ComponentScan
public class Springboot2Application extends SpringBootServletInitializer{
	private static final Logger LOGGER = LoggerFactory.getLogger(Springboot2Application.class);
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Springboot2Application.class);
	    }
    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }
}
