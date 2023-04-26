package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.api.utils.MD5Utils;
import com.mayikt.common.core.api.utils.RedisUtil;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
@RestController
public class LoginServiceImpl extends BaseApiService implements LoginService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public BaseResponse<String> login(String phoneNumber, String passWord) {
        //1.验证参数
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("phoneNumber is null");
        }
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("password is null");
        }
        //2.根据手机号查询到用户信息
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("phone_number", phoneNumber);
        SysUser sysdbUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if (sysdbUser == null) {
            return setResultError("该手机号码不存在");
        }
        String userMD5password = MD5Utils.md5(passWord + sysdbUser.getSalt());
        //3.数据库存放密码(MD5加密)==password+盐值
        String dbPassWord = sysdbUser.getPassword();
        if (!dbPassWord.equals(userMD5password)) {
            return setResultError("用户名称或密码错误");
        }
        String token = UUID.randomUUID().toString().replace("-","");
        //4.将token放入redis
        Integer userId = sysdbUser.getId();
        RedisUtil.setString(token, userId + "");
        //4.登录成功后,生成对应的token令牌,将该令牌返回客户端即可
        return setResultSuccessData(token);
    }
}
