package com.ydsy.javademo.po;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BusinessUser {
    private Integer id;

    private String businessName;

    private String location;

    private String account;

    private String password;

    private String phoneNumber;

    private String businessHours;
}
 // json {"id":1,"businessName":"test","location":"test","account":"test","password":"test","phoneNumber":"test","businessHours":"test"}