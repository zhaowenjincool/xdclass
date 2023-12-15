package org.example.controller;

import org.example.model.entity.User;
import org.example.model.request.LoginRequest;
import org.example.service.UserService;
import org.example.utils.CommonUtils;
import org.example.utils.JsonData;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("find_by_id")
    public User findUserById(@RequestParam(value="user_id",required = true) int userId){
       return userService.findByUserId(userId);
    }
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){
        int i = userService.save(userInfo);
        return i==0?JsonData.buildError("注册失败"):JsonData.buildSuccess();
    }
    
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        User user = userService.findUserByPhoneAndPwd(loginRequest.getPhone(), CommonUtils.MD5(loginRequest.getPwd()));
        if(user==null){
            return JsonData.buildError("登录失败，账号或密码错误");
        }else{
            String token = JwtUtils.generateToken(user);
            return JsonData.buildSuccess(token);
        }
    }
}
