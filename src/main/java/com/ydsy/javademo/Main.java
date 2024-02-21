package com.ydsy.javademo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setAge(18);
        System.out.println(user);
        // JSON {"id":1,"name":"test","age":18}

        // JSON.toJSONString()方法将Java对象转换为JSON字符串
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
        System.out.println("=====================================");
        String s1 = "{\"id\":1,\"name\":\"test\",\"age\":19}";
        // JSON.parseObject()方法将JSON字符串转换为Java对象
        User user1 = JSON.parseObject(s1, User.class);
        System.out.println(user1);

        System.out.println("=====================================");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        String jsonString1 = JSON.toJSONString(userList);
        // [{"age":18,"id":1,"name":"test"},{"age":19,"id":1,"name":"test"}]
        System.out.println(jsonString1);


        List<User> userList1 = JSON.parseArray(jsonString1, User.class);

        // 容器对象和字符串的互相转化


        // json 对象和字符串进行转换
        // 后端 数据库里面的内容 - mybatis 转对象 - json - 字符串- 前端
        // servlet 字符串（json） - 对象 - 走逻辑 - 插入/更新/删除数据库 - 返回结果（json）

    }
}
