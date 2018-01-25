package com.xlwansdk.common.aspect;

import com.xlwansdk.authorization.manager.TokenManager;
import com.xlwansdk.authorization.model.TokenModel;
import com.xlwansdk.common.annotation.IgnoreSecurity;
import com.xlwansdk.common.constant.Constants;
import com.xlwansdk.common.exception.TokenException;
import com.xlwansdk.common.utils.Base64Util;
import com.xlwansdk.common.utils.WebContextUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * token有效性判断切面
 * @author leeyom
 * @date 2017年10月19日 10:41
 */
@Component
@Aspect
public class SecurityAspect {

    private static final Logger LOGGER = Logger.getLogger(SecurityAspect.class);

    @Autowired
    TokenManager tokenManager;

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        //SimpleDateFormat是线程不安全的，设置为static，多线程情况下会报java.lang.NumberFormatException: multiple points
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        LOGGER.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        LOGGER.debug("Method : " + method.getName() + " : " + method.isAnnotationPresent(IgnoreSecurity.class));

        //如果是获取Swagger API文档，直接调用目标方法，生产环境下需要注释掉
        String methodName = method.getName();
        if ("getDocumentation".equals(methodName)) {
            return pjp.proceed();
        }

        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }

        // 从 request header 中获取当前 token
        String authentication = WebContextUtil.getRequest().getHeader(Constants.DEFAULT_TOKEN_NAME);
        // 从 request header 中获取时间戳
        String timestampStr = WebContextUtil.getRequest().getHeader(Constants.TIME_STAMP);
        TokenModel tokenModel = tokenManager.getToken(Base64Util.decodeData(authentication));

        Date date = new Date();
        Date timestamp = sdf.parse(timestampStr);

        //验证时间戳是否超过五分钟，如果超过五分钟，则服务端删除此token，防止抓包
        if (((date.getTime()) - timestamp.getTime()) / 60000 > 5) {
            if (tokenModel != null) {
                //删除token
                tokenManager.deleteToken(tokenModel.getUserId());
            }
            throw new TokenException("请求超时~");
        }

        // 检查 token 有效性
        if (!tokenManager.checkToken(tokenModel)) {
            String message = "token " + Base64Util.decodeData(authentication) + " is invalid！！！";
            LOGGER.debug("message : " + message);
            throw new TokenException(message);
        }
        // 调用目标方法
        return pjp.proceed();
    }
}
