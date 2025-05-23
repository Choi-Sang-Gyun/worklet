package com.project2.worklet.user.service;


import com.project2.worklet.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(UserVO user) {
        return userMapper.insertUser(user);
    }

    @Override
    public UserVO loginUser(Map<String, String> paramMap) {
        String userId = paramMap.get("userId");
        String userPw = paramMap.get("userPw");

        return userMapper.loginUser(userId, userPw);
    }

    @Override
    public UserVO getUserById(String userId) {
        return userMapper.getUserById(userId);
    }
}
