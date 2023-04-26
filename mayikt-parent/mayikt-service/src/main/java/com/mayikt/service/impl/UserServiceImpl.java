package com.mayikt.service.impl;

import com.baomidou.mybatisplus.generator.IFill;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.api.utils.MayiktBeanUtils;
import com.mayikt.common.core.api.utils.RedisUtil;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.UserService;
import com.mayikt.service.dto.UserRespDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl extends BaseApiService implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public BaseResponse<UserRespDto> getByTokenUserInfo(String token) {
        //1.验证参数
        if (StringUtils.isEmpty(token)) {
            return setResultError("token is null");
        }
        //2.根据token从redis中获取对应的userId
        String redisUserId = RedisUtil.getString(token);
        if (StringUtils.isEmpty(redisUserId)) {
            return setResultError("token error");
        }
        //3.根据userid查询数据库中用户信息
        Integer userId = Integer.parseInt(redisUserId);
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            return setResultError("token error");
        }
        //4.db中对象转化为dto对象
        UserRespDto userRespDto = MayiktBeanUtils.doToDto(sysUser, UserRespDto.class);
        //5.返回dto对象
        return setResultSuccessData(userRespDto);
    }
}
