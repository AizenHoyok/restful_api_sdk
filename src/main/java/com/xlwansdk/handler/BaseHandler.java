package com.xlwansdk.handler;

import com.xlwansdk.service.IMemberService;
import com.xlwansdk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 统一注入service实例
 * @author LiuYuJie
 * @date 2018-01-24 14:30:46
 */
@Controller
public class BaseHandler {

    @Autowired
    IMemberService service;

}
