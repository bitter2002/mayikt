package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.api.utils.MD5Utils;
import com.mayikt.common.core.api.utils.SaltUtils;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterServiceImpl extends BaseApiService implements RegisterService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public BaseResponse<String> register(String phoneNumber, String passWord) {
        //1.验证参数
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("phoneNumber is null");
        }
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("passWord is null");
        }
        //2.根据手机号码查询用户是否在数据库中存在,不存在才可以注册
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("phone_number", phoneNumber);
        SysUser sysdbUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if (sysdbUser != null) {
            return setResultError("该用户已经存在,无法重复注册");
        }
        //3.生成注册用户对应的盐值
        String salt = SaltUtils.getSalt();
        SysUser sysUser = new SysUser(phoneNumber, MD5Utils.md5(passWord + salt), salt);
        //4.用户注册---将数据放入数据库中
        int insertResult = sysUserMapper.insert(sysUser);
        return insertResult > 0 ? setResultSuccess() : setResultError("插入失败");

    }
}
