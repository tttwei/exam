package com.example.demo.entity;

import lombok.Data;

@Data
public class WeChatPhoneDTO {
    // getPhoneNumber接口返回的code
    private String code;
    // 小程序的appid（一般是在程序中配置，不需要前端传参）
    private String appid;
    // 小程序的secretKey（一般是在程序中配置，不需要前端传参）
    private String secretKey;
}
