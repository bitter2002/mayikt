package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserService {
    /*
     * 根据token查询用户信息
     * */
    @GetMapping("getByTokenUserInfo")
    BaseResponse<UserRespDto> getByTokenUserInfo(String token);
}
