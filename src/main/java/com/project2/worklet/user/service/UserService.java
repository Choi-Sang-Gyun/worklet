package com.project2.worklet.user.service;

import com.project2.worklet.command.UserVO;

import java.util.Map;

public interface UserService {

    // 회원가입
    int insertUser(UserVO user);

    // 로그인
    UserVO loginUser(Map<String, String> paramMap);

    UserVO getUserById(String userId);
}
