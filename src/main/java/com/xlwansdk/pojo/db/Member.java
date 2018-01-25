package com.xlwansdk.pojo.db;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "tab_member")
public class Member {
    @Id
    private Integer id;

    private String account;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 推广员工
     */
    private Integer inv;

    /**
     * 推广游戏
     */
    @Column(name = "invGame")
    private String invgame;

    /**
     * 注册时间
     */
    @Column(name = "regTime")
    private String regtime;

    /**
     * 注册IP
     */
    @Column(name = "regIp")
    private String regip;

    /**
     * 上次登录时间
     */
    @Column(name = "lastTime")
    private String lasttime;

    /**
     * 上次登录IP
     */
    @Column(name = "lastIp")
    private String lastip;

    /**
     * 所属分组
     */
    private Integer bgroup;

    /**
     * 所属分部
     */
    private Integer bid;

    /**
     * 余额
     */
    private BigDecimal money;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 身份证号码
     */
    private String card;

    /**
     * 真实名称
     */
    private String name;

    /**
     * 设备信息
     */
    private String device;

    /**
     * 游客类型
     */
    private Boolean tourist;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取推广员工
     *
     * @return inv - 推广员工
     */
    public Integer getInv() {
        return inv;
    }

    /**
     * 设置推广员工
     *
     * @param inv 推广员工
     */
    public void setInv(Integer inv) {
        this.inv = inv;
    }

    /**
     * 获取推广游戏
     *
     * @return invGame - 推广游戏
     */
    public String getInvgame() {
        return invgame;
    }

    /**
     * 设置推广游戏
     *
     * @param invgame 推广游戏
     */
    public void setInvgame(String invgame) {
        this.invgame = invgame;
    }

    /**
     * 获取注册时间
     *
     * @return regTime - 注册时间
     */
    public String getRegtime() {
        return regtime;
    }

    /**
     * 设置注册时间
     *
     * @param regtime 注册时间
     */
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    /**
     * 获取注册IP
     *
     * @return regIp - 注册IP
     */
    public String getRegip() {
        return regip;
    }

    /**
     * 设置注册IP
     *
     * @param regip 注册IP
     */
    public void setRegip(String regip) {
        this.regip = regip;
    }

    /**
     * 获取上次登录时间
     *
     * @return lastTime - 上次登录时间
     */
    public String getLasttime() {
        return lasttime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lasttime 上次登录时间
     */
    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    /**
     * 获取上次登录IP
     *
     * @return lastIp - 上次登录IP
     */
    public String getLastip() {
        return lastip;
    }

    /**
     * 设置上次登录IP
     *
     * @param lastip 上次登录IP
     */
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    /**
     * 获取所属分组
     *
     * @return bgroup - 所属分组
     */
    public Integer getBgroup() {
        return bgroup;
    }

    /**
     * 设置所属分组
     *
     * @param bgroup 所属分组
     */
    public void setBgroup(Integer bgroup) {
        this.bgroup = bgroup;
    }

    /**
     * 获取所属分部
     *
     * @return bid - 所属分部
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置所属分部
     *
     * @param bid 所属分部
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取余额
     *
     * @return money - 余额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置余额
     *
     * @param money 余额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取身份证号码
     *
     * @return card - 身份证号码
     */
    public String getCard() {
        return card;
    }

    /**
     * 设置身份证号码
     *
     * @param card 身份证号码
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * 获取真实名称
     *
     * @return name - 真实名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实名称
     *
     * @param name 真实名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取设备信息
     *
     * @return device - 设备信息
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置设备信息
     *
     * @param device 设备信息
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * 获取游客类型
     *
     * @return tourist - 游客类型
     */
    public Boolean getTourist() {
        return tourist;
    }

    /**
     * 设置游客类型
     *
     * @param tourist 游客类型
     */
    public void setTourist(Boolean tourist) {
        this.tourist = tourist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", pwd=").append(pwd);
        sb.append(", inv=").append(inv);
        sb.append(", invgame=").append(invgame);
        sb.append(", regtime=").append(regtime);
        sb.append(", regip=").append(regip);
        sb.append(", lasttime=").append(lasttime);
        sb.append(", lastip=").append(lastip);
        sb.append(", bgroup=").append(bgroup);
        sb.append(", bid=").append(bid);
        sb.append(", money=").append(money);
        sb.append(", mobile=").append(mobile);
        sb.append(", mail=").append(mail);
        sb.append(", card=").append(card);
        sb.append(", name=").append(name);
        sb.append(", device=").append(device);
        sb.append(", tourist=").append(tourist);
        sb.append("]");
        return sb.toString();
    }
}