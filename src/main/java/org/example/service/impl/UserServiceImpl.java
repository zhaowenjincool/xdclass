package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.model.entity.User;
import org.example.service.UserService;
import org.example.utils.CommonUtils;
import org.example.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserId(int userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public int save(Map<String,String> userInfo) {
        return userMapper.save(parseToUser(userInfo));
    }

    @Override
    public User findUserByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findUserByPhoneAndPwd(phone, pwd);
        return user;
    }

    private User parseToUser(Map<String,String> userInfo){
        if(userInfo.containsKey("name") && userInfo.containsKey("phone") && userInfo.containsKey("pwd")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")));
            user.setPhone(userInfo.get("phone"));
            user.setCreateTime(LocalDateTime.now());
            user.setHeadImg(getRandomImg());

            return user;
        }else{
            return null;
        }
    }

    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
