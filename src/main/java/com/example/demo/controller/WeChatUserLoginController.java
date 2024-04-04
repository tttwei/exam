package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import com.example.demo.entity.WeChatPhoneDTO;
import com.example.demo.entity.WeChatPhoneInfo;
import com.example.demo.utils.WeChatUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class WeChatUserLoginController {
    /**
     * 用前端请求接口获取的code换取用户手机号
     * 前端需要请求的接口：https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html
     * @param weChatPhone
     * @return
     */
    @PostMapping("/phone")
    public String getPhone(@RequestBody WeChatPhoneDTO weChatPhone){
        // 1.请求微信接口服务，获取accessToken
        JSONObject accessTokenJson = WeChatUtil.getAccessToken(weChatPhone.getAppid(), weChatPhone.getSecretKey());
        String accessToken = accessTokenJson.get("access_token",String.class);
        // 2.请求微信接口服务，获取用户手机号信息
        JSONObject phoneNumberJson = WeChatUtil.getPhoneNumber(weChatPhone.getCode(), accessToken);
        WeChatPhoneInfo phoneInfo = phoneNumberJson.get("phone_info", WeChatPhoneInfo.class);
        return phoneInfo.getPurePhoneNumber();
    }
}
