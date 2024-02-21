package com.ydsy.javademo.service;

import com.ydsy.javademo.po.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    User selectByPrimaryKey(Integer id);
    int insert(User record);
    int updateByPrimaryKeySelective(User record);
    int deleteByPrimaryKey(Integer id);

}
