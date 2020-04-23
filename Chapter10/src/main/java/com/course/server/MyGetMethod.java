package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/")
public class MyGetMethod {

    @RequestMapping(value = "getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "成功获得 cookies 信息~~~";
    }

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带 cookies 访问", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带 cookies 信息访问";
        }
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return "你必须携带 cookies 信息访问";
    }

    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带 参数才能访问的 get 请求", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();

        myList.put("鞋", 333);
        myList.put("篮球", 232);
        myList.put("足球", 325);

        return myList;
    }

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数访问的 get 的第二种请求的实现", httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String, Integer> myList = new HashMap<>();

        myList.put("鞋", 333);
        myList.put("篮球", 232);
        myList.put("足球", 325);
        return myList;
    }
}
