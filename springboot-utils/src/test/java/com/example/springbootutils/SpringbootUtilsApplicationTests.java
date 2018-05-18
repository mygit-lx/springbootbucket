package com.example.springbootutils;

import com.example.entity.UserInfo;
import com.example.service.IUserInfoService;
import com.example.utils.StringUtil;
import com.example.utils.encrypt.MD5Util;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootUtilsApplicationTests {

	public final static String KEY = "NQ0eSXs720170114";

	@Autowired
	private IUserInfoService iUserInfoService;

	@Test
	public void contextLoads() {
//		String path = GetResource.class.getClassLoader().getResource("excelTemplates/test/custom_test.xls").getPath();
//		System.out.println(path);

		StringBuffer str = new StringBuffer("address=北京上地三街9号&empty_plot=56&lat=32.466666&lng=123.994449&name=北京上地三街9号院停车场&park_id=1001&phone=13899884433&rand=0.20354312785198048&total_plot=90&union_id=10001");
		String addKey = str.append("key=").append(KEY).toString();
		System.out.println(addKey);
		String md5= MD5Util.encode(addKey).toUpperCase();
		System.out.println(md5);
	}

	@Test
	public void test01(){
		List<UserInfo> allUserInfo = iUserInfoService.findAllUserInfo();
		System.out.println(allUserInfo.toString());
	}

}
