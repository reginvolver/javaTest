package com.ydsy.javademo.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydsy.javademo.common.BasicResultVO;
import com.ydsy.javademo.po.BusinessUser;
import com.ydsy.javademo.service.BusinessService;
import com.ydsy.javademo.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/business/*")
public class BusinessServlet extends BaseServlet {
    private BusinessService businessService = new BusinessServiceImpl();

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException      business/login
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Brand对象
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        resp.getWriter().write("success");
    }

    /**
     * 删除
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException      business/delete
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        JSONObject jsonObject = JSON.parseObject(readLine);
        String account = jsonObject.getString("bsaccount");
        String id = jsonObject.getString("bsid");
        if (StrUtil.isBlank(account) || StrUtil.isBlank(id)) {
            BasicResultVO<Object> fail = BasicResultVO.fail("无法提交空白！");
            resp.getWriter().write(JSON.toJSONString(fail));
        } else {
            int result = businessService.delete(id, account);
            if (result > 0) {
                BasicResultVO<Object> success = BasicResultVO.success("删除成功！");
                resp.getWriter().write(JSON.toJSONString(success));
            } else {
                BasicResultVO<Object> fail = BasicResultVO.fail("删除失败！");
                resp.getWriter().write(JSON.toJSONString(fail));
            }
        }
    }

    /**
     * 注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException      business/register
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       BufferedReader reader = req.getReader();
        //{"id":1,"businessName":"test","location":"test","account":"test","password":"test","phoneNumber":"test","businessHours":"test"}
        String registerUserStr = reader.readLine();
        BusinessUser businessUser = JSON.parseObject(registerUserStr, BusinessUser.class);
        int register = businessService.register(businessUser);
        if (register > 0) {
            BasicResultVO<Object> success = BasicResultVO.success("注册成功！");
            resp.getWriter().write(JSON.toJSONString(success));
        } else {
            BasicResultVO<Object> fail = BasicResultVO.fail("注册失败！");
            resp.getWriter().write(JSON.toJSONString(fail));
        }
    }
}
