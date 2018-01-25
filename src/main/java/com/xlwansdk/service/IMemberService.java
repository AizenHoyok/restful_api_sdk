package com.xlwansdk.service;

import com.xlwansdk.pojo.db.Member;

/**
 * Member的service接口层
 * @author Liu YuJie
 * @date 2018-01-24 14:27:44
 *
 */
public interface IMemberService extends IBaseService<Member> {

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    Member login(String account, String password);

    int register(Member member);

    int getCount();

    Member is_real_name(String account);

    int varify_real_name(String account, String name, String card);

    Member getId(String account);
}
