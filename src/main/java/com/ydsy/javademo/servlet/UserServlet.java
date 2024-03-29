package com.ydsy.javademo.servlet;


import com.alibaba.fastjson.JSON;
import com.ydsy.javademo.common.BasicResultVO;
import com.ydsy.javademo.mapper.UserMapper;
import com.ydsy.javademo.po.User;
import com.ydsy.javademo.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet/*")
public class UserServlet extends BaseServlet {
    private String message;

    // public void init() {
    //     message = "Hello World1111111!";
    // }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取Brand对象
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        resp.getWriter().write("success");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取Brand对象
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        resp.getWriter().write("success");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取Brand对象
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        resp.getWriter().write("success");
    }

    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(req.getMethod().equals("POST")){
            BasicResultVO<Object> fail = BasicResultVO.fail("请求方式错误");
            resp.getWriter().write(JSON.toJSONString(fail));
        }
        //获取Brand对象
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        resp.getWriter().write("success");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = userService.selectAll();
        response.setContentType("application/json");
        // json
        // 接口正常不正常 数据是啥 有没有状态码
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        BasicResultVO<List<User>> result = BasicResultVO.success("获取数据成功", users);
        response.getWriter().write(JSON.toJSONString(result));
    }
    //
    // // dopost
    // @Override
    // public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     // // 不是浏览器地址栏的输入
    //     // // json {"id": 1}
    //     // request.setCharacterEncoding("UTF-8");
    //     //
    //     // response.setCharacterEncoding("UTF-8");
    //     // response.setContentType("application/json");
    //     //
    //     // // reader 读取请求内容
    //     // BufferedReader reader = request.getReader();
    //     // StringBuilder requestBody = new StringBuilder();
    //     // String line;
    //     //
    //     // while ((line = reader.readLine()) != null) {
    //     //     requestBody.append(line);
    //     // }
    //     // System.out.println("接收到来自前端的数据了！：");
    //     // System.out.println(requestBody.toString());
    //     // String givePar = requestBody.toString();
    //     // User user = JSON.parseObject(givePar, User.class);
    //     // System.out.println("解析后的user对象是：");
    //     // System.out.println(JSON.toJSONString(user));
    //     // String resource = "mybatis-config.xml";
    //     // InputStream inputStream = null;
    //     //
    //     // inputStream = Resources.getResourceAsStream(resource);
    //     //
    //     // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //     //
    //     // SqlSession sqlSession = sqlSessionFactory.openSession();
    //     //
    //     // UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    //     // int i = mapper.updateByPrimaryKey(user);
    //     // System.out.println(i);
    //     // sqlSession.commit();
    //     // sqlSession.close();
    //     // if (i >= 1) {
    //     //     BasicResultVO<Object> success = BasicResultVO.success("更新成功");
    //     //     response.getWriter().write(JSON.toJSONString(success));
    //     // } else {
    //     //     response.getWriter().write(JSON.toJSONString(BasicResultVO.fail("更新失败")));
    //     // }
    // }
    //
    //
    //
    // public void destroy() {
    // }
}