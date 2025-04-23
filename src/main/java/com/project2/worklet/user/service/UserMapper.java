package com.project2.worklet.user.service;

import com.project2.worklet.command.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapper {
    int insertUser(UserVO user);
    UserVO loginUser(@Param("userId") String userId, @Param("userPw") String userPw);
    UserVO getUserById(String userId);

}
