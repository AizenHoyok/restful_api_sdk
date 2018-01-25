package com.xlwansdk.dao;

import com.xlwansdk.common.utils.MyMapper;
import com.xlwansdk.pojo.db.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper extends MyMapper<Member> {
    Member login(@Param("account") String account,@Param("password") String password);

    int register(@Param("member") Member member);

    int getCount();

    Member is_real_name(@Param("account") String account);

    int varify_real_name(@Param("account") String account,@Param("name") String name, @Param("card") String card);

    Member getId(@Param("account") String account);
}