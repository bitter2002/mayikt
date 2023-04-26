package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;

public interface RegisterService {
    @PostMapping("/register")
    BaseResponse<String> register(String phoneNumber, String passWord);
}
