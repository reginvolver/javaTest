package com.ydsy.javademo.mapper;


import com.ydsy.javademo.po.BusinessUser;

public interface BusinessUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessUser record);

    int insertSelective(BusinessUser record);

    BusinessUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessUser record);

    int updateByPrimaryKey(BusinessUser record);
}