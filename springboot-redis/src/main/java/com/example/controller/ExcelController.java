package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.City;
import com.example.domain.User;
import com.lkx.util.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel操作类
 */
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

    /**
     * 读取Excel-本地
     * @param request
     */
    @RequestMapping(value = "/read/local")
    public void readExcel(HttpServletRequest request) throws Exception{
        String keyValue ="西安:name,新疆:two,阿克苏:three";
        List<City> list=ExcelUtil.readXls("/home/luox/Documents/test02.xls",ExcelUtil.getMap(keyValue),"com.example.domain.City");

        for (City city : list) {
            System.out.println("<li><em>"+city.getName()+"</em><em>"+ city.getTwo()+"</em><em>"+city.getThree()+"</em></li>");
        }
    }

    /**
     * 导出Excel-本地
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/export/local")
    public void exportLocal(HttpServletRequest request) throws Exception{
        List list = new ArrayList();
        list.add(new User(1,"aa","111"));
        list.add(new User(2,"bb","222"));
        list.add(new User(3,"cc","333"));
        list.add(new User(4,"dd","444"));
        String keyValue ="编号:id,用户名:username,密码:password";
        ExcelUtil.exportExcel("/home/luox/Documents/test01.xls",keyValue,list,"com.example.domain.User");
    }

    /**
     * 导出Excel-浏览器
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/export/web")
    public void exportWeb(HttpServletResponse response) throws Exception{
        List list = new ArrayList();
        list.add(new User(1,"aa","111"));
        list.add(new User(2,"bb","222"));
        list.add(new User(3,"cc","333"));
        list.add(new User(4,"dd","444"));
        String keyValue ="编号:id,用户名:username,密码:password";
        ExcelUtil.exportExcelOutputStream(response,keyValue,list,"com.example.domain.User","test");
    }

    /**
     * 导入Excel
     * @param file
     * @throws Exception
     */
    @RequestMapping(value = "/read/web")
    public void importExcel(MultipartFile file) throws Exception{
        String keyValue ="编号:id,用户名:username,密码:password";
        List<User> list = ExcelUtil.readXls(file.getBytes(), ExcelUtil.getMap(keyValue), "com.example.domain.User");
        System.out.println(JSONObject.toJSON(list));
    }
}
