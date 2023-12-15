package org.example.mapper;

import org.example.model.entity.User;
import org.example.utils.JsonData;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    User findUserById(int userId);

    int save(User user);

    User findUserByPhoneAndPwd(String phone,String pwd);
}
