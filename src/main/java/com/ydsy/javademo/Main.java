package com.ydsy.javademo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.BCrypt;

public class Main {
    public static void main(String[] args) {
        // 加密
        String hashpw = BCrypt.hashpw("123456");
        System.out.println(hashpw);
        // 判断密码是否正确
        boolean checkpw = BCrypt.checkpw("123456", "$2a$10$lXc44uUYA/5xT3E30kQpo.9eaGoVqNWpErWjgU4AaXUFAh59cdb5W");
        System.out.println(checkpw);
    }
}
