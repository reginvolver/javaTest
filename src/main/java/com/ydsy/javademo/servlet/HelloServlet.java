package com.ydsy.javademo.servlet;


import com.alibaba.fastjson.JSON;
import com.ydsy.javademo.mapper.UserMapper;
import com.ydsy.javademo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World1111111!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(user));

        response.setContentType("application/json");
        response.getWriter().println(JSON.toJSONString(user));
    }

    public void destroy() {
    }
}