package com.ydsy.javademo;

import lombok.*;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String name;
    private int age;
}
