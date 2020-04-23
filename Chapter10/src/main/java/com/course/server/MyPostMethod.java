package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是所有的 post 请求")
@RequestMapping("/v1")
public class MyPostMethod {
    // 定义变量封装 cookies 信息
    private static Cookie cookie;

    // 用户登录成功获取到 cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取 cookies 信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password){
        if(username.equals("zhangsan") && password.equals("123qwe")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜登录成功~~";
        }
        return "用户名 或 密码错误~~";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        // 获取 cookies
        Cookie[] cookies = request.getCookies();
        // 验证 cookies 是否合法
        for (Cookie c: cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUsername().equals("zhangsan")
                    && u.getPassword().equals("123qwe")

            ){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }


}
