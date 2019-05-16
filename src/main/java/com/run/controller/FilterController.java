package com.run.controller;

import com.run.pojo.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 访问路径直接转到index.html
 * 需要使用thymeleaf这个依赖
 * 文件上传
 */
@Controller
//  在 配置文件中配置变量后，使用value注解就可以调用D:\ideaworkspace\springboot\src\main\resources\
@PropertySource("classpath:application.properties")
public class FilterController {
    @RequestMapping(value = "/api/index")
    public Object index(){
        return "index";
    }
    @Value("${web.images-path}")
    private  String filePath;
    @ResponseBody
    @RequestMapping("/upload")
    public JsonData upload(@RequestParam("head_jpg")MultipartFile file, HttpServletRequest request){
        String  name=request.getParameter("name");
        System.out.println("文件上传路径"+filePath);
        System.out.println("用户名"+name);
        System.out.println("看看trigger文件管用不");
//        获取上传的文件名
        String fileName=file.getOriginalFilename();
        System.out.println("上传的文件名"+fileName);
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传文件后缀名"+suffixName);
//        上传后的文件名
        fileName= UUID.randomUUID()+suffixName;
        File dest = new File(filePath + fileName);
        System.out.println("转换后的文件名"+dest.getName());
//        file.isEmpty() 判断文件是否为空
//        file.getSize()对文件大小进行控制
        try {
//          用于文件保存，效率比FileOutputStream高
            file.transferTo(dest);
            return new JsonData(0,fileName);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new JsonData(0,null,"not save file");
    }
}
