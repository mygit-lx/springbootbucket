package com.example.test;

import com.example.test.config.properties.ComplexProperty;
import com.example.test.config.properties.ComplexPropertyNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({ComplexProperty.class,ComplexPropertyNew.class})
public class TestApplication implements CommandLineRunner{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (String s : context.getBeanDefinitionNames()) {
			if("testAutoConfiguration".equals(s)){
				LOGGER.info(s);
			}
		}
	}
}
