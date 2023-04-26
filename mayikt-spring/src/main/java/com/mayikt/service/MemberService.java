package com.mayikt.service;

import com.mayikt.dao.MemberDao;

public class MemberService {
    /*
    * 使用属性注入的方式
    * */
    private MemberDao memberDao;
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    public void addMember(){
        //原生方式
       // new MemberDaoImpl().addMember();

        System.out.println(">MemberService.addMember()<");
        memberDao.addMember();
    }
}
