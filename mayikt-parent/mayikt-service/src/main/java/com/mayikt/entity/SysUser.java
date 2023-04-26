package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author mayikt
 * @since 2023-01-06
 */
@TableName("sys_user")
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登陆名称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本
     */
    private Integer version;

    public SysUser() {
    }

    public SysUser(String phoneNumber, String password, String salt) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.salt = salt;
    }

    public SysUser(Integer id, String deptId, String name, String userName, String email, String phoneNumber, String sex, String avatar, String password, String salt, LocalDate birthday, String status, String delFlag, String loginIp, LocalDateTime loginDate, LocalDateTime createTime, String updateBy, String remark, Integer version) {
        this.id = id;
        this.deptId = deptId;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.avatar = avatar;
        this.password = password;
        this.salt = salt;
        this.birthday = birthday;
        this.status = status;
        this.delFlag = delFlag;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.remark = remark;
        this.version = version;
    }

}
