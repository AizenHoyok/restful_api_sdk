package com.xlwansdk.dao;

import com.xlwansdk.common.utils.MyMapper;
import com.xlwansdk.pojo.db.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {

    User getUser(@Param("userName") String userName, @Param("password") String password);

}