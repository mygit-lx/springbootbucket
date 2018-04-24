package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: 上传文件
 *
 * @author: luoxiang
 *
 * @create: 2018-04-03 10:19
 **/
@Controller
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static String UPLOAD_FOLDER = "E:\\log\\test\\upload\\";

    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "upload";
    }

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if(StringUtils.isEmpty(file)){
            redirectAttributes.addFlashAttribute("message","请选择一个文件上传！");
            return "redirect:errorMsg";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path,bytes);
            redirectAttributes.addFlashAttribute("message",file.getOriginalFilename()+",上传成功！");
        }catch (Exception e){
            logger.error("上传文件异常:-----=>"+e.getMessage());
            e.printStackTrace();
            return "redirect:errorMsg";
        }
        return "redirect:message";
    }

    @RequestMapping("/message")
    public String message() {  return "message";
    }

    @RequestMapping("/errorMsg")
    public String errorMsg() {
        return "error";
    }
}
