package com.run.controller;

import org.springframework.web.bind.annotation.*;
/**

* @Description:    java类作用描述

* @Author:         linmeng

* @CreateDate:     2019/4/28 13:22

* @UpdateUser:     linmeng

* @UpdateDate:     2019/4/28 13:22

* @UpdateRemark:   修改内容

* @Version:        1.0

*/

@RestController
public class HelloController {
    @RequestMapping("/")
    public @ResponseBody String hello(){
        return "hello";
    }


}
