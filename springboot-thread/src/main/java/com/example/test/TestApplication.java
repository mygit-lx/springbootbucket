package com.example.test;

import com.example.test.config.properties.ComplexProperty;
import com.example.test.config.properties.ComplexPropertyNew;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ComplexProperty.class,ComplexPropertyNew.class})
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
