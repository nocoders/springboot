package com.run.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试http协议的post，del，put请求
 */
@RestController
public class OtherHttpController {
    private Map<String,Object> params=new HashMap<>();

    @PostMapping("/v1/login")
    public Object login(String id, String pwd){
        params.clear();
        params.put("id",id);
        params.put("pwd",pwd);
        return params;
    }
//    更新
    @PutMapping("/v1/put")
    public Object put(String id){
        params.clear();
        params.put("id",id);
        return params;
    }

    @DeleteMapping("/v1/del")
    public Object del(String id){
        params.clear();
        params.put("id",id);
        return params;
    }
}
