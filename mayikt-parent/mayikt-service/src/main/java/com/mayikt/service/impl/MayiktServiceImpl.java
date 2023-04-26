package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.MayiktService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
public class MayiktServiceImpl extends BaseApiService implements MayiktService {

    @Override
    public String getMayikt() {
        return "ok";
    }

    @Override
    public BaseResponse<String> getMayikt2() {
//        HashMap<Object, Object> result = new HashMap<>();
//        result.put("code", "200");
//        result.put("msg", "ok");
//        result.put("data", "data");
        //工具类封装 jsonUtils.result("200","ok",data)
        return setResultSuccess();
    }

    @Override
    public BaseResponse<String> getMayikt3(Integer age) {
        Integer j = 1 / age;
        return setResultSuccessData(j);
    }
}
