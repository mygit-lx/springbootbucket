package com.example.controller;

import com.example.entity.Man;
import com.example.entity.UserInfo;
import com.example.exception.ExcelException;
import com.example.service.IUserInfoService;
import com.example.utils.excel.ExcelUtil;
import com.example.utils.excel.JxlsUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @description: 操作Excel
 *
 * @author: luoxiang
 *
 * @create: 2018-04-03 10:19
 **/
@Controller
@RequestMapping(value = "/user")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/userInfo")
    public String findUserInfo(RedirectAttributes redirectAttributes){
        List<UserInfo> allUserInfo = iUserInfoService.findAllUserInfo();
        logger.info("获取的用户信息：{}",allUserInfo.toArray());
        redirectAttributes.addFlashAttribute("userList",allUserInfo);
        return "userList";
    }

    /**
     * 浏览器导出用户信息Excel-非模板
     * @param request
     * @param response
     */
    @RequestMapping(value = "/user/exportExcel/normal_01")
    public void userInfoExportExcel(HttpServletRequest request,HttpServletResponse response){
        List<UserInfo> allUserInfo = iUserInfoService.findAllUserInfo();
        logger.info("获取的用户信息：{}",allUserInfo.toArray());
        String titleColumn[] = {"id","borrowerName","nationality","sex","education","phone","email","idno","maritalStatus","homeAdress","creatTime"};
        String titleName[] = {"序号","性别","国别","性别","教育程度","手机号","电子邮箱","身份证号码","婚姻状况","家庭地址","创建时间"};
        try {
            ExcelUtil.listToExcelB(allUserInfo,titleColumn,titleName,"",response,new String("用户信息".getBytes(),"iso-8859-1"));
        } catch (ExcelException e) {
            logger.error("导出Excel文件异常{}",e);
        } catch (UnsupportedEncodingException e) {
            logger.error("导出Excel，文件名编码转换异常{}",e);
        }
    }

    /**
     * 浏览器导出Excel-非模板
     * @param request
     * @param response
     */
    @RequestMapping(value = "/downExcel")
    public void downExcel(HttpServletRequest request, HttpServletResponse response){
        //数据
        List<Man> dataList = new ArrayList();
        Man man1 = new Man("张三",20,"男",(float)10000.8);
        Man man2 = new Man("李四",21,"男",(float)11000.8);
        Man man3 = new Man("王五",22,"女",(float)1200.8);
        Man man4 = new Man("赵六",23,"男",(float)13000.8);
        Man man5 = new Man("田七",24,"男",(float)14000.8);
        Man man6 = new Man();
        man6.setName("老八");
        dataList.add(man1);dataList.add(man2);dataList.add(man3);dataList.add(man4);dataList.add(man5);
        dataList.add(man6);
        //调用
        String titleColumn[] = {"name","sex","idCard","salary"};
        String titleName[] = {"姓名","性别","身份证号","月薪"};
        try {
            ExcelUtil.listToExcelB(dataList,titleColumn,titleName,"",response,new String("用户".getBytes(),"iso-8859-1"));
        } catch (ExcelException e) {
            logger.error("导出Excel文件异常{}",e);
        } catch (UnsupportedEncodingException e) {
            logger.error("导出Excel，文件名编码转换异常{}",e);
        }
    }

//    @RequestMapping(value = "/findUser/{id}")
//    public String findUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
//        UserInfo user = iUserInfoService.findUser(id);
//        logger.info("获取的用户信息：{}",user.toString());
//        redirectAttributes.addFlashAttribute("userList",user);
//        return "userList";
//    }

    /**
     * 通过模板导出excel-指定路径导出
     */
    @RequestMapping(value = "/test/exportExcel/template_01")
    public void exportExcelByTemplate(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                map.put("key"+j,"value"+j);
            }
            list.add(map);
        }
        for (int m = 0; m < 13; m++) {
            map1.put("key"+m,"value"+m);
        }
        map1.put("nowdate",new Date());
        map1.put("phone","18513572398");
        System.out.println(list);
        System.out.println(map1);

        try {
            String path = GetResource.class.getClassLoader().getResource("excelTemplates/test/custom_test.xls").getPath();
            JxlsUtils.exportExcelToPath(path,list,map1,"E:\\custom\\custom-test01.xls");
        } catch (ExcelException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过模板导出excel-浏览器导出
     */
    @RequestMapping(value = "/test/exportExcel/template_02")
    public void exportExcelByTemplateRe(HttpServletRequest request,HttpServletResponse response) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                map.put("key" + j, "value" + j);
            }
            list.add(map);
        }
        for (int m = 0; m < 13; m++) {
            map1.put("key" + m, "value" + m);
        }
        map1.put("nowdate", new Date());
        map1.put("phone", "18513572398");
        System.out.println(list);
        System.out.println(map1);
        try {
            String path = GetResource.class.getClassLoader().getResource("excelTemplates/test/custom_test.xls").getPath();
            JxlsUtils.exportExcel(path, "测试.xls",list, map1, response);
        } catch (ExcelException e) {
            e.printStackTrace();
        }
    }

}
