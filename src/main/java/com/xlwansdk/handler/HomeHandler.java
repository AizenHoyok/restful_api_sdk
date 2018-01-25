package com.xlwansdk.handler;


import com.xlwansdk.authorization.manager.TokenManager;
import com.xlwansdk.authorization.model.TokenModel;
import com.xlwansdk.common.annotation.IgnoreSecurity;
import com.xlwansdk.common.constant.Constants;
import com.xlwansdk.common.constant.StatusCode;
import com.xlwansdk.common.utils.Base64Util;
import com.xlwansdk.common.utils.SHA;
import com.xlwansdk.common.utils.WebContextUtil;
import com.xlwansdk.pojo.db.Member;
import com.xlwansdk.pojo.db.User;
import com.xlwansdk.pojo.vo.MemberVo;
import com.xlwansdk.pojo.vo.ResultBean;
import com.xlwansdk.pojo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;

import javax.servlet.http.HttpSession;

/**
 * 平台登录登出
 * @author LiuYuJie
 * @date 2017年10月19日 12:06
 */
@Api(description = "平台登录注册", tags = "HomeHandler", basePath = "/home")
@Controller
@RequestMapping("/home")
public class HomeHandler extends BaseHandler {

    private static final Logger LOGGER = Logger.getLogger(HomeHandler.class);

    @Autowired
    private TokenManager tokenManager;

    /**
     * 登录
     * @param account 玩家账号
     * @param password 密码，SHA加密
     * @return 登录结果信息
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "account", value = "玩家账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登陆密码", required = true, dataType = "String"),
    })
    @ResponseBody
    @IgnoreSecurity
    public ResultBean login(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password) {
        ResultBean resultBean = new ResultBean();
        MemberVo memberVo = new MemberVo();
        try {
            password = SHA.getResult(password+ Constants.SECURITY_KEY);
            Member member = service.login(account, password);
            if (member == null) {
                resultBean.setCode(StatusCode.HTTP_FAILURE);
                resultBean.setMsg("Login failed, user name or password error！");
            } else {
                TokenModel token;
                // 判断用户是否已经登录过，如果登录过，就将redis缓存中的token删除，重新创建新的token值，保证一个用户在一个时间段只有一个可用 Token
                boolean hasToken = tokenManager.hasToken(member.getId());
                if (hasToken) {
                    //清除过时的token
                    tokenManager.deleteToken(member.getId());
                    //创建token
                    token = tokenManager.createToken(member.getId());
                } else {
                    //创建token
                    token = tokenManager.createToken(member.getId());
                }

                memberVo.setId(member.getId());
                memberVo.setAccount(member.getAccount());
                //将token返回给客户端
                memberVo.setToken(Base64Util.encodeData(token.getToken()));
                resultBean.setData(memberVo);
            }
        } catch (Exception e) {
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("Login failed, user name or password error！");
            LOGGER.error("用户登录失败！参数信息：userName = " + account + ",password = " + password, e);
            e.printStackTrace();
        }
        return resultBean;
    }

    /**
     * 注册
     * @param member
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "member", value = "用户数据", required = true, dataType = "long")
    })
    @IgnoreSecurity
    @ResponseBody
    public ResultBean register(Member member){
        ResultBean resultBean = new ResultBean();
        MemberVo vo = new MemberVo();
        try {
            member.setPwd(SHA.getResult(member.getPwd()+ Constants.SECURITY_KEY));
            int i = service.register(member);
            if (i <= 0){
                resultBean.setCode(StatusCode.HTTP_FAILURE);
                resultBean.setMsg("Register failed,valid account repeat");
            }else {
                vo.setId(member.getId());
                vo.setAccount(member.getAccount());
                resultBean.setCode(StatusCode.HTTP_SUCCESS);
                resultBean.setMsg("Register success!");
            }
        }catch (Exception e){
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("Login failed, valid account repeat！");
            service.deleteByPrimaryKey(member.getId());
            LOGGER.error("用户注册失败！参数信息：" + member.toString(), e);
            e.printStackTrace();
        }
        return resultBean;
    }

    /**
     * 游客登陆
     * @param member
     * @return
     */
    @ApiOperation(value = "游客登陆", notes = "游客登陆")
    @RequestMapping(value = "/yk_login", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "member", value = "用户数据", required = true, dataType = "long")
    })
    @IgnoreSecurity
    @ResponseBody
    public ResultBean yk_login(Member member){
        ResultBean resultBean = new ResultBean();
        member.setTourist(true);
        MemberVo vo = new MemberVo();
        try {
            member.setPwd(SHA.getResult("123456"+ Constants.SECURITY_KEY));
            int count = service.getCount();
            count = count + 1;
            member.setAccount(Constants.PROMOTE_NAME+count);
            int i = service.register(member);
            if (i <= 0){
                resultBean.setCode(StatusCode.HTTP_FAILURE);
                resultBean.setMsg("Register failed,valid account repeat");
            }else {
                TokenModel token;
                //创建token
                token = tokenManager.createToken(member.getId());
                vo.setId(member.getId());
                vo.setAccount(member.getAccount());
                //将token返回给客户端
                vo.setToken(Base64Util.encodeData(token.getToken()));
                resultBean.setCode(StatusCode.HTTP_SUCCESS);
                resultBean.setMsg("Register success!");
                resultBean.setData(vo);
            }
        }catch (Exception e){
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("Login failed,valid account repeat！");
            service.deleteByPrimaryKey(member.getId());
            LOGGER.error("游客注册失败！参数信息： " + member.toString(), e);
            e.printStackTrace();
        }
        return resultBean;
    }

    /**
     * 是否以验证实名制
     * @param account
     * @return
     */
    @ApiOperation(value = "是否以验证实名制", notes = "是否以验证实名制")
    @RequestMapping(value = "/test_real_name", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "account", value = "用户账号", required = true, dataType = "string")
    })
    @IgnoreSecurity
    @ResponseBody
    public ResultBean test_real_name(@RequestParam(value = "account") String account) {
        ResultBean resultBean = new ResultBean();
        try {
            Member member = service.is_real_name(account);
            if (member == null) {
                resultBean.setCode(StatusCode.HTTP_SUCCESS);
                resultBean.setMsg("varify failed, the user havn't varify real name！");
            } else {
                resultBean.setData(member);
            }
        } catch (Exception e) {
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("varify failed!");
            LOGGER.error("遇到未知错误，退出失败！", e);
        }
        return resultBean;
    }

    /**
     * 验证实名制
     * @param account
     * @return
     */
    @ApiOperation(value = "验证实名制", notes = "验证实名制")
    @RequestMapping(value = "/varify_real_name", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "account", value = "用户账号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "真实姓名", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "card", value = "身份证号", required = true, dataType = "string")
    })
    @ResponseBody
    public ResultBean varify_real_name(@RequestParam(value = "account") String account,@RequestParam(value = "name") String name,@RequestParam(value = "card") String card) {
        ResultBean resultBean = new ResultBean();
        try {
            String authentication = WebContextUtil.getRequest().getHeader(Constants.DEFAULT_TOKEN_NAME);
            TokenModel tokenModel = tokenManager.getToken(Base64Util.decodeData(authentication));
            Member user = service.getId(account);
            if (tokenModel.getUserId() == user.getId()){
                int change_row = service.varify_real_name(account,name,card);
                if (change_row <= 0){
                    resultBean.setCode(StatusCode.HTTP_FAILURE);
                    resultBean.setMsg("varify failed,please try again");
                }else {
                    resultBean = test_real_name(account);
                }
            }else {
                resultBean.setCode(StatusCode.HTTP_FAILURE);
                resultBean.setMsg("不能修改他人信息!");
                LOGGER.error("不能修改他人信息！");
            }
        } catch (Exception e) {
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("varify failed!");
            LOGGER.error("验证实名制失败！", e);
        }
        return resultBean;
    }




    /**
     * 登出
     * @param session
     * @param userId
     * @return
     */
    @ApiOperation(value = "用户登出", notes = "用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, dataType = "long")
    })
    @IgnoreSecurity
    @ResponseBody
    public ResultBean logout(HttpSession session, @RequestParam(value = "userId") Long userId) {
        ResultBean resultBean = new ResultBean();
        try {
            tokenManager.deleteToken(userId);
            session.invalidate();
        } catch (Exception e) {
            resultBean.setCode(StatusCode.HTTP_FAILURE);
            resultBean.setMsg("Logout failed!");
            LOGGER.error("遇到未知错误，退出失败！", e);
        }
        return resultBean;
    }
}
