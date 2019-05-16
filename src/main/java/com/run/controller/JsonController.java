package com.run.controller;

import com.run.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonController {
    @GetMapping(value = "/v1/test_json")
    public Object testJson(){
        return new User(111,"pwd123","18518971279",new Date());
    }
}
