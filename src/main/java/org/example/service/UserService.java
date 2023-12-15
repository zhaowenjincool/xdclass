package org.example.service;

import org.example.model.entity.User;
import org.example.utils.JsonData;

import java.util.Map;

public interface UserService {
    User findByUserId(int userId);
    int save(Map<String,String> userInfo);
    User findUserByPhoneAndPwd(String phone,String pwd);
}
