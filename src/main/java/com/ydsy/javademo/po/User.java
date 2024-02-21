package com.ydsy.javademo.po;

import lombok.*;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    /**
     * 主键id 自增
     */
    private Integer id;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 密码
     */
    private String password;
}