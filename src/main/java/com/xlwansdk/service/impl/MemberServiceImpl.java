package com.xlwansdk.service.impl;

import com.xlwansdk.dao.MemberMapper;
import com.xlwansdk.pojo.db.Member;
import com.xlwansdk.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IUserService接口实现类
 * @author LiuYuJie
 * @date 2017年10月26日 15:15
 */
@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements IMemberService {

    @Autowired
    MemberMapper mapper;

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    @Override
    public Member login(String account, String password) {
        return mapper.login(account,password);
    }

    @Override
    public int register(Member member) {
        return mapper.register(member);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public Member is_real_name(String account) {
        return mapper.is_real_name(account);
    }

    @Override
    public int varify_real_name(String account, String name, String card) {
        return mapper.varify_real_name(account,name,card);
    }

    @Override
    public Member getId(String account) {
        return mapper.getId(account);
    }
}
