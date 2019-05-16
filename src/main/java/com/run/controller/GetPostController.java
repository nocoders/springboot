package com.run.controller;

import com.run.pojo.ServerSettings;
import com.run.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@RestController
public class GetPostController {
    private Map<String,Object> params=new HashMap<>();

    /**
     * 测试restFul协议，从路径中获取字段
     * @param cityId
     * @param userId
     * @return
     */
//    @RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id")String cityId, @PathVariable("user_id")String userId){
        params.clear();
        params.put("cityId",cityId);
        params.put("user_id",userId);
        return params;
    }

    /**
     * GetMapping使用
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     * RequestParam给传入变量起别名，赋默认值
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "0",name = "page") int from, int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     * RequestBody传递对象
     * @param user
     * @return
     */
    @PostMapping(value = "/v1/save_user")
    public Object saveUser2(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }

    /**
     * 获取HTTP 头信息
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping(value = "/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,String id ){
        params.clear();
        params.put("access_token",accessToken);
        params.put("id",id);
        return params;
    }

    /**
     * 获取request
     * @param request
     * @return
     */
    @GetMapping(value = "/v1/get_request")
    public Object getRequest(HttpServletRequest request){
        params.clear();
        int a=1/0;
        String id=request.getParameter("id");
        params.put("id",id);
        return params;
    }
    @Autowired
    private ServerSettings serverSettings;
    @GetMapping(value = "/v1/testProperties")
    public Object testPropertie(HttpServletRequest request){

        return serverSettings;
    }
}
