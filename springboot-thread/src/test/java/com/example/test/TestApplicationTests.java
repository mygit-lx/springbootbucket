package com.example.test;

import com.example.test.config.properties.TestProperty;
import com.example.test.service.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	@Autowired
	private TestProperty testProperty;

	@Autowired
	private PropertyService propertyService;

	@Test
	public void contextLoads() {
		String name = testProperty.getName();
		System.out.println("------name------");
		System.out.println(name);
		System.out.println("------secret------");
		System.out.println(testProperty.getSecret());
		System.out.println("------setup------");
		System.out.println(testProperty.getSetup());
		System.out.println("------range-int------");
		System.out.println(testProperty.getRangeInt());
		System.out.println("------uuid------");
		System.out.println(testProperty.getUuid());
		System.out.println("------domain------");
		System.out.println(testProperty.getDomain());
		System.out.println("------username------");
		System.out.println(testProperty.getUsername());
		System.out.println("------password------");
		System.out.println(testProperty.getPassword());
	}

	@Test
	public void test01(){
		System.out.println("roles:-->"+propertyService.roles());
		System.out.println("enabled:-->"+propertyService.enabled());
		System.out.println("name:-->"+propertyService.name());
		System.out.println("password:-->"+propertyService.password());
		System.out.println("username:-->"+propertyService.userName());
	}

	@Test
	public void test02(){
		System.out.println("password:-->"+propertyService.passwordNew());
		System.out.println("username:-->"+propertyService.userNameNew());
		System.out.println("roles:-->"+propertyService.rolesNew());
		System.out.println("work:-->"+propertyService.work());
	}
}
