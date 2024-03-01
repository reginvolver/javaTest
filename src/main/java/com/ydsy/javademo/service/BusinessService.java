package com.ydsy.javademo.service;

import com.ydsy.javademo.po.BusinessUser;

public interface BusinessService {
    int delete(int id);
    int login(String account, String pwd);
    int register(BusinessUser businessUser);
}
