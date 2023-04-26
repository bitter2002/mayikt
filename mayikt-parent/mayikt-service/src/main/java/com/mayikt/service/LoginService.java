package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;

public interface LoginService {
    /*
     * 登录
     * */
    @PostMapping("/login")
    BaseResponse<String> login(String phoneNumber, String passWord);
}
