package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface MayiktService {
    @GetMapping("/getMayikt")
    String getMayikt();

    @GetMapping("/getMayikt2")
    BaseResponse<String> getMayikt2();

    @GetMapping("/getMayikt3")
    BaseResponse<String> getMayikt3(Integer age);
}
