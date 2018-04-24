package com.example.springbootutils;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootUtilsApplicationTests {

	@Test
	public void contextLoads() {
		String path = GetResource.class.getClassLoader().getResource("excelTemplates/test/custom_test.xls").getPath();
		System.out.println(path);
	}

}
