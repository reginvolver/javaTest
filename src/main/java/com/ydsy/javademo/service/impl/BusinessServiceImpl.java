package com.ydsy.javademo.service.impl;

import com.ydsy.javademo.mapper.BusinessUserMapper;
import com.ydsy.javademo.po.BusinessUser;
import com.ydsy.javademo.service.BusinessService;
import com.ydsy.javademo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {


    @Override
    public int delete(int id) {
        int result = SqlSessionFactoryUtils.getMapper(BusinessUserMapper.class).deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int login(String account, String pwd) {
        return 0;
    }

    @Override
    public int register(BusinessUser businessUser) {
        InputStream inputStream = BusinessUserMapper.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BusinessUserMapper mapper = sqlSession.getMapper(BusinessUserMapper.class);
        int result = mapper.insert(businessUser);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
